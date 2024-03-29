# [2] Thread

### 학습 목표

### 1. Thread가 무엇인지 알 수 있다.

### 2. MultiThread에 대해 알 수 있다.



## 1. Thread (스레드)

- 프로세스의 실행 단위
- 한 프로세스 내에서 동작되는 여러 실행 흐름으로, 프로세스 내의 주소 공간이나 자원을 공유할 수 있다
- 같은 프로세스에 속한 다른 스레드와 코드, data section, 그리고 열린 파일이나 신호와 같은 운영체제 자원들을 공유한다
- 스레드는 프로세스 내에서 각각 Stack만 따로 할당받고, Code, Data, Heap 영역은 공유한다



## 2. Multi Process vs Multi Thread

### Multi Process

- 하나의 응용 프로그램을 여러 개의 프로세스로 구성하여 각 프로세스가 하나의 작업을 처리하도록 하는 것

#### 장점

- 여러 개의 자식 프로세스 중 하나에 문제가 발생하면, 그 자식 프로세스만 죽음
- 다른 곳으로 영향이 확산되지 않음

#### 단점

- Context Switching 에서의 오버 헤드
- 프로세스 간 통신 기법 IPC



### Multi Thread

- 하나의 응용 프로그램을 여러 개의 스레드로 구성하고 각 스레드가 하나의 작업을 처리하도록 하는 것
- 윈도우, 리눅스 등 많은 OS 들이 멀티 프로세싱을 지원하고 있지만, 멀티 스레딩을 기본으로 함

#### 장점

- 메모리 공간과 시스템 자원 소모가 줄어듦
- 스레드 간 통신 시, 전역 변수의 공간 꼬든 동적으로 할당된 공간인 Heap 영역을 이용하여 데이터를 주고 받으므로, 통신 방법이 간단함
- 문맥 전환이 빠르다

#### 단점

- 서로 다른 스레드가 Data, Heap 영역을 공유하기 때문에 자원 공유의 문제가 발생함 (동기화와 연결)
- 하나의 스레드에 문제가 생기면 전체 프로세스가 영향을 받음



## 3. Sync vs Async

### Synchronous (동기 : 동시에 일어나는)

- 메소드를 실행시킴과 **동시에** 반환 값이 기대되는 경우
- 동시에 반환 값이 기대된다?
  - 실행되었을 때 값이 반환되기 전까지 `Blocking` 되어 있다는 것을 의미
- 바로 요청을 하면 시간이 얼마가 걸리던지 간에 요청한 자리에서 결과가 주어짐
- 요청과 결과가 한 자리에서 동시에 일어남
- A 노드와 B 노드 사이의 작업 처리 단위 (transaction)를 동시에 맞추겠다
- 설계가 매우 간단하고 직관적이지만, 결과가 주어질 때까지 아무것도 못하고 대기해야 한다는 단점 존재



### Asynchronous (비동기 : 동시에 일어나지 않는)

- 메소드를 실행시킴과 동시에 반환 값이 기대되지 않는 경우
- `blocking` 되지 않고, 이벤트 큐에 넣거나 백그라운드 스레드에게 해당 task를 위임하고 바로 다음 코드를 실행하기 때문에 기대되는 값이 바로 반환되지 않음
- 요청한 그 자리에서 결과가 주어지지 않는다
- 노드 사이의 작업 처리 단위를 동시에 맞추지 않아도 됨
- 동기보다는 설계가 복잡하지만, 결과가 주어지는 데 시간이 걸리더라도 그 시간 동안 다른 작업을 할 수 있기에 자원을 효율적으로 사용할 수 있다는 장점 존재

