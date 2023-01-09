# Airflow
- AirBnB에서 만든 workflow management tool이다.
- workflow는 DAG (Directed Acyclic Graph)로 표현되고, 개별 워크플로우는 task라고 칭해진다.
- DAG는 task 간 dependency와 실행 순서, 재시도 등을 보여준다.


## Task와 Operator의 차이

### Operator
- 단일 작업 수행 역할을 한다
- BashOperator, PythonOperator, EmailOperator, HTTPOperator 등 단일 작업을 수행한다.

### Task
- 작업의 올바른 실행을 보장하기위한 Opreator의 Wrapper 또는 Manager
- Operator의 상태를 관리하고 사용자에게 상태 변경 (시작 / 완료)을 표시하는 Airflow의 내장 컴포넌트


```python
import json
import pathlib

import airflow
import requests
import requests.exceptions as request_exceptions
from airflow import DAG
from airflow.operators.bash import BashOperator
from airflow.operators.bash import PythonOperator

# DAG => 모든 워크플로우의 시작점, 워크플로우 내의 모든 태스크는 DAG 개체를 참조한다
dag=DAG(
    dag_id="download_rocket_launches", # Airflow UI에 표시되는 DAG 이름
    start_date=airflow.utils.dates.days_ago(14), # 워크플로우가 처음 실행 되는 날짜
    schedule_interval=None, # DAG 실행 간격 (None이면, DAG가 자동으로 실행되지 않음을 의미한다)
)

# 1. Launch 라이브러리에서 결과값 다운로드
# Bash 커맨드를 실행하기 위해 BashOperator 객체 인스턴스 설정
# 각 Operator는 하나의 task를 수행하고, 여러 개의 Operator가 Airflow의 워크플로우를 구성한다
download_launches=BashOperator(
    task_id="download_launches", # task 이름
    bash_command="curl -o /tmp/launches.json 'https://ll.thespacedevs.com/2.0.0/launch/upcoming'", # 실행할 bash command
    dag=dag, # DAG 변수에 대한 참조
)

def _get_pictures():
    # 경로가 존재하는지 확인
    pathlib.Path("/tmp/images").mkdir(parents=True, exist_ok=True)

    # launches.json 파일에 있는 모든 그림 파일을 다운로드
    with open("/tmp/launches.json") as f:
        launches=json.load(f)
        image_urls=[launch["image"] for launch in launches["results"]]
        for image_url in image_urls:
            try:
                response=requests.get(images_url)
                image_filename=image_url.split("/")[-1]
                target_file=f"/tmp/images/{image_filename}"
                with open(target_file, "wb") as f:
                    f.write(response.content)
                print(f"Downloaded {image_url} to {target_file}")
            except request_exceptions.MissingSchema:
                print(f"{image_url} appears to be an invalid URL.")
            except request_exceptions.ConnectionError:
                print(f"Could not connect to {image_url}.")


# PythonOperator를 사용하여 위에서 정의한 Python 함수를 호출한다
get_pictures=PythonOperator(
    task_id="get_pictures",
    python_callable=_get_pictures,
    dag=dag,
)

notify=BashOperator(
    task_id="notify",
    bash_command='echo "There are now $(ls /tmp/images/ | wc -l) images."',
    dag=dag,
)

# 오퍼레이터의 dependency 지정 (task 실행 순서 정의)
download_launches >> get_pictures >> notify
```


### Airflow의 PythonOperator
- 파이썬 코드 실행을 담당한다
- Operator 자신을 정의해야 한다.
- `python_callable`은 인수에 호출 가능한 일반 함수를 가리킨다.
- 오퍼레이터 실행 시 파이썬 함수가 호출되고, 함수를 실행한다
