# Vuex 기술 요소

#### - state : 여러 컴포넌트에 공유되는 `data`

#### - getters : 연산된 state 값을 접근하는 속성 `computed`

#### - mutations : state 값을 변경하는 이벤트 로직 or 메서드 `methods`

#### - actions : 비동기 처리 로직을 선언하는 메서드 `async methods` ex) API Call



## state 란?

### 여러 컴포넌트 간에 공유할 `data` - 상태

```javascript
// Vue
data: {
	message: 'Hello Vue.js!'
}

// Vuex
state: {
	message: 'Hello Vue.js!'
}
```

- Vuex는 여러 컴포넌트 간 state가 공유된다는 특징이 있음



- Vue와 Vuex 이용 시 접근 방식의 차이

```html
<!--Vue-->
<p>{{ message }}</p>

<!--Vuex-->
<p>{{ this.$store.state.message }}</p>
```



## getters 란?

### state 값을 쉽게 접근하는 속성이자, `computed()` 처럼 미리 연산된 값을 접근하는 속성

```javascript
// store.js
state: {
	num: 10
},
getters: {
	getNumber(state) {
		return state.num;
	},
	doubleNumber(state) {
		return state.num * 2;
	}
}
```

- 표현식

  ```html
  <p>{{ this.$store.getters.getNumber }}</p> <!--10-->
  <p>{{ this.$store.getters.doubleNumber }}</p> <!--20-->
  ```



## mutations 란?

### state의 값을 변경할 수 있는 유일한 방법 이자 메서드

### mutation은 `commit()` 으로 동작시킴

```javascript
// store.js
state: {
	num: 10
},
mutations: {
	printNumbers(state) {
		return state.num
	},
	sumNumbers(state, anotherNum) {
		return state.num + anotherNum;
	}
}

// App.vue
this.$store.commit('printNumbers'); // 10
this.$store.commit('sumNumbers', 20); // 30
```



## mutations의 commit() 형식

### state를 변경하기 위해 mutations를 동작시킬 때 인자 (payload)를 전달할 수 있음

```javascript
// store.js
state: {
	storeNum: 10
},
mutations: {
	modifyState(state, payload) {
		console.log(payload.str);
		return store.storeNum += payload.num; // 30
	}
}

// App.vue
this.$store.commit('modifyState', {
	str: 'passed from payload',
	num: 20
});
```

