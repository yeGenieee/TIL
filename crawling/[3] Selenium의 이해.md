# Selenium

### 웹을 테스트하기 위한 프레임워크

- 공식 홈페이지 : http://www.seleniumhq.org
- Selenium with Python : http://selenium-python.readthedocs.io/index.html



## 사전 준비 (Selenium 설치)

1. Selenium Install :  `pip install selenium`
2. 웹 드라이버 install : 웹 테스트 코드 자동화를 위해 제공되는 툴 (각 browser 및 os 별로 존재)
   - selenium - 테스트 코드를 사용하여 브라우저에서의 액션을 테스트할 수 있게 해주는 툴
   - Firefox, chromedriver 등 각 브라우저마다 웹 드라이버 다운로드 가능
   - https://sites.google.com/a/chromium.org/chromedriver/ (Chrome 브라우저용)
3. 설치 후, 다음 사이트에서 가장 최신 버전을 다운로드 받아서, 덮어씌움
   - https://chromedriver.storage.googleapis.com/index.html
   - Window : C:/dev_python/Webdriver/chromedriver.exe
   - Mac OS : /usr/local/Cellar/chromedriver/chromedriver

>  chrome://version 으로 브라우저에서 확인 후, 버전에 맞는 드라이버를 설치해도 됨



## 특정 사이트에서 검색 결과 가져오기

> selenium 예제

- 크롤링 사이트 호출 및 확인

```python
# 크롤링 할 사이트 호출
driver.get("http://www.python.org")

# Selenium은 웹 테스트를 위한 프레임워크로 다음과 같은 방식으로 웹 테스트를 자동으로 진행함 (참고)
assert "Python" in driver.title # 웹 브라우저의 title에 Python이 없으면 에러 발생을 해라
```



- 주요 함수 -  find_element_by_name(), find_elements_by_name()

  - fine_element_by_name() : 최초 발견한 name으로 가져오기

  - find_elements_by_name() : name 이 동일한 모든 리스트를 가져오기

    ```python
    # <input id="id-search-field" name="q" 검색창 name으로 검색하기
    # 태그 name으로 특정한 태그를 찾을 수 있음
    elem = driver.find_element_by_name("q")
    ```

