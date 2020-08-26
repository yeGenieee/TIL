# [11] XPATH를 이용해서 크롤링하기

- XPath : XML 문서의 특정 요소나 속성에 접근하기 위한 경로를 지정하는 언어

## 핵심정리

1. 태그와 속성으로 선택하기

```python
crawling_data = soup.find('h1')
crawling_data = soup.find(id='title')
crawling_data = soup.find('p', class='cssstyle')
crawling_data = soup.find('p', attrs = {'align': 'center'})
```

2. CSS Selector 로 선택하기

```python
crawling_data = soup.select('html > title')
crawling_data = soup.select('div.article_view')
crawling_data = soup.select('#harmonyContainer')
crawling_data = soup.select('div#mArticle div#harmonyContainer')
```



## XPATH를 이용해서 크롤링하기

- / : 절대경로를 나타냄
- // : 문서 내에서 검색
- //@href : href 속성이 있는 모든 태그 선택
- //a[@href='http://google.com'] : a 태그의 href 속성에 http://google.com 속성값을 가진 모든 태그 선택
- (//a)[3] : 문서의 세 번째 링크 선택
- (//table)[last()] : 문서의 마지막 테이블 선택
- //table/tr/* : 모든 테이블에서 모든 자식 tr 태그 선택
- //div[@*] : 속성이 하나라도 있는 div 태그 선택

```python
# 문서 내 태그 검색
title = driver.find_element_by_xpath("//title") # 문서내의 어떤 태그든지 가능

# 절대 경로
title = driver.find_element_by_xpath("/html/head/title")

# html 태그 내에서 다시 검색
title = driver.find_element_by_xpath("/html//title") # html 태그 내에서 title 태그를 찾아라

# soup.find('h3', attrs = {'class' : 'tit_s'})
title_content = driver.find_element_by_xpath("//h3[@class='tit_view']")
```



