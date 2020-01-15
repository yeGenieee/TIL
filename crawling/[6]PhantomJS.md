# PhantomJS

### PhantomJS : 화면이 없는 브라우저

- **꼭 크롤링을 위해 페이지 화면까지 띄워서 볼 필요는 없으니, 화면은 띄우지 말자**
- 시간이 단출될 것이라고 기대하지만, **실제로는 유사하거나 느린 경우도 있으므로** 경우에 따라 선택 사용
  - WebTesting 을 위해 나온 화면이 존재하지 않는 브라우저
  - 터미널 환경에서 동작하는 크롤러의 경우 PhantomJS 브라우저 사용 권장
  - 최근에는, phantomJS를 selenium 내에서 지원하지 않는 경우가 있음



### 사전 준비 (PhantomJS) 설치

1. 윈도우 / 맥 : PhantomJS 다운로드 후 적절한 디렉토리에 압축을 품 (http://phantomjs.org/download.html)

   > 맥의 경우 brew install phontomjs 터미널 명령을 통해서도 설치 가능 (단, brew 설치 시)
   >
   > - Homebrew 설치 (https://brew.sh/index_ko)



### PhantomJS 로드

```python
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

phantomjs_file = '/usr/local/Cellar/phantomjs/2.1.1/bin/phantomjs'
driver = webdriver.PhantomJS(phantomjs_file) # 맥
```



## Headless Chrome : 최신 크롤링 기술

> 가능한 모든 크롤링 기술도 다룬다

- Headless Chrome : PhantomJS 와 유사한 기술로 크롬 브라우저 기능으로 개발됨
  - 성능 상 개선이 있다는 주장도 있음

> headlesschrome.ipynb



### Headless Chrome  사용법

- 일전에 사용한 모든 기능 / 코드 동일

  - 크롬 브라우저 버전만 최소 60 이상이면 기능 사용 가능

  - 다음 코드만 추가해주면 됨

  - headless chrome 사용을 선언하는 chrome_options를 넣어주면 됨
  
  - `driver = webdriver.Chrome(chromedriver, options=options)`
  
    ```python
    from selenium import webdriver
    from selenium.webdriver.common.keys import Keys
    import time
    
    options = webdriver.ChromeOptions()
    options.add_argument('headless')
    options.add_argument('window-size=1920x1080') # 웹 브라우저의 사이즈 지정
    options.add_argument("disable-gpu") # grapic card를 사용하지 않는다
    options.add_argument("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_)") # head 에 User Agent 지정
    options.add_argument("lang=ko_KR")
    
    chromedriver = '/usr/local/Cellar/chromedriver/chromedriver'
    driver = webdriver.Chrome(chromedriver, options=options)
  driver.get('http://v.media.daum.net/v/20170202185812986')
    
    body = driver.find_element_by_id('harmonyContainer')
    print(body.text)
  driver.quit()
    ```
    



```python
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

chromdriver = '/usr/local/Cellar/chromedriver/chromedriver'
headless_options = webdriver.ChromeOptions()
headless_options.add_argument('headless')
driver = webdriver.Chrome(chromedriver, options=headless_options)

driver = webdriver.Chrome(chromedriver)
```

