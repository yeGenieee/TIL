# 크롤링 (Crawling)

## Web Crawler

- 인터넷에 있는 웹 페이지를 방문하여, 자료를 수집하고 DB에 저장하는 프로그램

- 웹 크롤러가 하는 작업을 웹 크롤링이라고 함
  1. HTML 페이지를 가져와서, HTML / CSS 등을 파싱하고, 필요한 데이터만 추출하는 기법
  2. Open API (Rest API) 를 제공하는 서비스에 Open API를 호출해서, 받은 데이터 중 필요한 데이터만 추출하는 기법
  3. Selenium 등 브라우저를 프로그래밍으로 조작하여, 필요한 데이터만 추출하는 기법



## 강력한 크롤링 기술

- Selenium / PhantomJS / Headless Chrome
- Scrapy


## 크롤링 기초 정리

- 파이썬 입문과 크롤링 기초 부트 캠프 강좌를 통해 익힌 내용 정리



### 크롤링 핵심 코드 패턴으로 이해하기

```python
import requests # 라이브러리 import
from bs4 import BeautifulSoup

res = request.get('http://v.media.daum.net/v/20170615203441266') # 웹 페이지 가져오기
soup = BeautifulSoup(res.content, 'html.parser') # 웹 페이지 파싱
mydata = soup.find('title') # 필요한 데이터 추출하기
print(mydata.get_text()) # 추출한 데이터 활용하기
```



### 1. 크롤링에 필요한 라이브러리

- requests
  - 웹페이지 가져오기 라이브러리
- bs4 (BeautifulSoup)
  - 웹페이지 분석(크롤링) 라이브러리

```python
import requests
from bs4 import BeautifulSoup
```



### 2. 웹 페이지 가져오기

- res.content 에 내가 크롤링한 결과물 (html 파일)이 저장됨

```
res = requsets.get('http://v.media.daum.net/v/20170615203441266')
```



### 3. 웹 페이지 파싱하기

- 파싱 (Parsing)이란?
  - 문자열의 의미 분석

> 이를 어떻게 일일이 코드로 만들까? ==> BeautifulSoup 라이브러리 이용

- soup 에 HTML 파일을 파싱한 정보가 들어감!

```python
soup = BeautifulSoup(res.content, 'html.parser')
```



### 4. 필요한 데이터 추출하기

> 이 부분이 크롤링의 핵심

- soup.find() 함수로 원하는 부분을 지정하면 됨
- 변수 .get_text() 함수로 추출한 부분을 가져올 수 있음

```python
mydata = soup.find('title')
print(mydata.get_text())
```

> 이를 위해 HTML언어로 어떻게 웹 페이지를 만드는지, 기본 내용을 이해할 필요가 있음



1. 태그와 속성으로 선택

   ```python
   crawling_data = soup.find('h1')
   crawling_data = soup.find(id = 'title')
   crawling_data = soup.find('p', class='cssstyle')
   crawling_data = soup.find('p', attrs = {'align': 'center'})
   ```

2. CSS Selector로 선택하기

   ```python
   crawling_data = soup.select('html > title')
   crawling_data = soup.select('div.article_view')
   crawling_data = soup.select('#harmonyContainer')
   crawling_data = soup.select('div#mArticle')
   ```

   

3. 추출한 데이터 활용하기

   > 필요한 데이터를 변수에 넣으면 이후 활용은 프로그래밍 영역

   ```python
   print(mydata.get_text())
   ```

### 업무 자동화 기술

- 크롤링 데이터 기반, 엑셀 보고서 만들기
- 크롤링 데이터 기반, 구글 쉬트 보고서 만들기

### 다양한 크롤링 기술

- 유용한 데이터를 크롤링할 수 있는 Open API
- 로그인이 필요한 웹페이지 크롤링 기법
- 크롤링 데이터 후처리
  - 문자열 함수, 정규 표현식
  -  JSON, XML 데이터 포맷



### 패턴 총정리

> 다음 코드를 우선 쓰고, 두 부분만 수정!

```python
import requests
from bs4 import BeautifulSoup

res = requests.get('http://v.media.daum.net/v/~~~~') # 크롤링 할 페이지 주소

soup = BeautifulSoup(res.content, 'html.parser')

mydata = soup.find('title') # 필요한 데이터 추출하는 코드 넣기

print(mydata.get_text()) # 추출한 데이터를 변수에 넣은 후, 원하는 프로그래밍
```



출처 : https://www.fun-coding.org/crawl_basic2.html [잔재미코딩] - 웹 크롤링 기본 - 크롤링(crawling) 이해 및 기본

