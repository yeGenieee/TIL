# HTTP 라이브러리와 Ajax 그리고 Vue Resource

## Axios

  뷰에서 권고하는 HTTP 통신 라이브러리

Promise 기반의 HTTP 통신 라이브러리이며, 상대적으로 다른 HTTP 통신 라이브러리들에 비해 문서화가 잘되어있고 API가 다양함



## Ajax

  Ajax(Asynchronous JavaScript and XML, 에이잭스)는 비동기적인 웹 애플리케이션의 제작을 위해 아래와 같은 조합을 이용하는 웹 개발 기법

- 표현 정보를 위한 HTML (또는 XHTML) 과 CSS
- 동적인 화면 출력 및 표시 정보와의 상호작용을 위한 DOM, 자바스크립트
- 웹 서버와 비동기적으로 데이터를 교환하고 조작하기 위한 XML, XSLT, XMLHttpRequest (Ajax 애플리케이션은 XML / XSLT 대신 미리 정의된 HTML이나 일반 텍스트, JSON, JSON-RPC를 이용할 수 있음)



Ajax 기법을 통해 데이터를 받아올 수 있음, SPA 구현이 쉽다



## Vue Resource

  이전에는 Vue Resource 가 HTTP Client 공식 라이브러리였음, 현재는 사용 X



## Axios

  뷰에서 권고하는 HTTP 통신 라이브러리, **Promise 기반의 HTTP 통신 라이브러리**이며, 상대적으로 다른 HTTP 통신 라이브러리들에 비해 문서화가 잘되어있고, API가 다양함



### 자바스크립트의 비동기 처리 패턴

1. callback
2. promise
3. promise + generator
4. async & await



### Axios 설치

- NPM 방식

  ```bash
  $ npm install axios
  ```

- CDN 방식

  ```html
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  ```



####  Error Handling, Canceling, Interceptors

