# Selenium을 이용하여 특정 사이트에서 검색 결과 가져오기

> selenium 예제

- 크롤링 사이트 호출 및 확인

```python
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

chromedriver = '/usr/local/Cellar/chromedriver/chromedriver'
driver = webdriver.Chrome(chromedriver)

# 크롤링 할 사이트 호출
driver.get("http://www.python.org")

# Selenium은 웹 테스트를 위한 프레임워크로 다음과 같은 방식으로 웹 테스트를 자동으로 진행함 (참고)
assert "Python" in driver.title # 웹 브라우저의 title에 Python이 없으면 에러 발생을 해라
```



```python
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

chromedriver = '/usr/local/Cellar/chromedriver/chromedriver'
driver = webdriver.Chrome(chromedriver)

driver.get("http://www.python.org")
assert "Python" in driver.title # 제목에 Python이 있으면 --> 다음 실행, 없으면 --> 중단

elem = driver.find_element_by_name("q")
elem.clear()

elem.send_keys("python")

elem.send_keys(Keys.RETURN)
```



- 주요 함수 -  find_element_by_name(), find_elements_by_name()

  - fine_element_by_name() : 최초 발견한 name으로 가져오기

  - find_elements_by_name() : name 이 동일한 모든 리스트를 가져오기

    ```python
    # <input id="id-search-field" name="q" 검색창 name으로 검색하기
    # 태그 name으로 특정한 태그를 찾을 수 있음
    elem = driver.find_element_by_name("q")
    ```



- 주요 함수

  - clear() : input 텍스트 초기화 하기

  - send_keys(키워드) : 키보드 입력값 전달하기

    - Keys.RETURN - 엔터기

    - dir(Keys) 로 키에 대응되는 이름 찾기

      ```python
      # input 텍스트 초기화
      elem.clear()
      
      # 키 이벤트 전송
      elem.send_keys("python")
      
      # 엔터 입력
      elem.send_keys(Keys.RETURN)
      ```

      

- 주요 함수

  - assert로 driver.page_source 에서 특정 키워드 확인하기

  - time.sleep() 함수로 일정 시간 브라우저 내용 확인할 수 있도록 하기

  - driver.quit() 함수로 브라우저 끝내기

    ```python
    assert "No results found." not in driver.page_source # driver.page_source 내에 No result found가 나오지 않으면 --> 다음 실행, No result found 가 나오면 중단
    
    # 명시적으로 일정 시간을 기다릴 수 있음 (10초 기다림)
    time.sleep(10)
    
    # 크롬 브라우저 닫기 가능함
    driver.quit()
    ```




- 주요 함수

  - find_element_by_tag_name() : 최초 발견한 태그만 가져오기

  - find_elements_by_tag_name() : 모든 태그 리스트로 가져오기

    ```python
    # <input id="id-search-field" name="q" 검색창 name으로 검색하기
    # 태그 name으로 특정한 태그를 찾을 수 있음
    elem = driver.find_element_by_name("q")
    ```

    > 참고
    >
    > - find_element_by_tag_name : 태그 이름 (최초 태그)
    > - find_elements_by_tag_name : 태그 이름 (모든 태그)

    ```python
    from selenium import webdriver
    from selenium.webdriver.common.keys import Keys
    import time
    
    chromedriver = '/usr/local/Cellar/chromedriver/chromedriver'
    driver = webdriver.Chrome(chromedriver)
    
    driver.get('http://www.python.org')
    assert "Python" in driver.title
    
    elem = driver.find_element_by_name("q")
    
    elem.clear()
    
    # 키 이벤트 전송
    elem.send_keys("python")
    
    # 엔터 입력
    elem.send_keys(Keys.RETURN)
    assert "No result found." not in driver.page_source
    
    # 명시적으로 일정 시간 기다릴 수 있음 (10초 기다림)
    time.sleep(2)
    
    h3s = driver.find_elements_by_tag_name("h3")
    for h3 in h3s:
        print(h3.text)
    
    # 크롬 브라우저 닫기
    driver.quit()
    ```