# Vue 템플릿 문법

  뷰의 템플릿 문법이란, 뷰로 화면을 조작하는 방법을 의미함

템플릿 문법은 데이터 바인딩과 디렉티브로 나뉨



## 데이터 바인딩

  데이터 바인딩은 뷰 인스턴스에서 정의한 속성들을 화면에 표시하는 방법

가장 기본적인 데이터 바인딩 방식은 **콧수염 괄호 (Mustache Tag)**

```html
<div>{{ message }}</div>
```

```javascript
new Vue({
	data: {
		message: 'Hello Vue.js'
	}
})
```

- div 태그에 콧수염 괄호를 이용하여 뷰 인스턴스의 `message` 속성을 연결함



## 디렉티브

  디렉티브는 뷰로 화면의 요소를 더 쉽게 조작하기 위한 문법

화면 조작에서 자주 사용되는 방식들을 모아 디렉티브 형태로 제공함

```html
<div>
	Hello <span v-if="show">Vue.js</span>
</div>
```

```javascript
new Vue({
	data: {
		show: false
	}
})
```

