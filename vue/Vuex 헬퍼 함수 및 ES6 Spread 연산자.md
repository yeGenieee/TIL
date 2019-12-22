# Vuex 헬퍼 함수 및 ES6 Spread 연산자

## 각 속성들을 더 쉽게 사용하는 방법 - Helper

### Store에 있는 아래 4가지 속성들을 간편하게 코딩하는 방법

#### - state -> mapState

#### - getters -> mapGetters

#### - mutations -> mapMutations

#### - actions -> mapActions



## 1. 헬퍼의 사용법

- 헬퍼를 사용하고자 하는 vue 파일에서 아래와 같이 해당 헬퍼를 로딩

  ```javascript
  // App.vue
  import { mapState } from 'vuex'
  import { mapGetters } from 'vuex'
  import { mapMutations } from 'vuex'
  import { mapActions } from 'vuex'
  
  export default {
    computed() { 
      ...mapState(['num']),
      ...mapGetters(['countedNum'])
    },
    methods: {
      ...mapMutations(['clickBtn']),
      ...mapActions(['asyncClickBtn'])
    }
  }
  ```

  - 이 컴포넌트 내에서 `this.num`을 하면 `this.$store.state.num` 과 동일
  - `this.countedNum` 은 `this.$store.getters.countedNum` 과 동일

- `...` 은 ES6의 **Object Spread Operator** 

  - `...` 은 각 속성 내 property를 다 들고 옴

    ```javascript
    let josh = {
    	field: 'web',
    	language: 'js'
    };
    
    let developer = {
    	nation: 'korea',
      field: josh.field,
      language: josh.language
    };
    
    console.log(developer);
    ```

  - ES6 Object Sperad Operator를 이용하여 위와 동일하게 작성

    ```javascript
    let josh = {
    	field: 'web',
    	language: 'js'
    };
    
    let developer = {
    	nation: 'korea'
    	...josh
    };
    ```



## mapState

### Vuex에 선언한 state 속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼

```javascript
// App.vue
import { mapState } from 'vuex'

computed() {
	...mapState(['num'])
  // num() { return this.$store.state.num; } 와 동일
}
}

// store.js
state: {
  num: 10
}
```

```html
<!-- <p>{{ this.$store.state.num }}</p> --> <!-- mapState를 쓰지 않았을 때 store에 접근하는 방법 -->
<p>{{ this.num }}</p>
```



## mapGetters

### Vuex에 선언한 getters 속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼

```javascript
// App.vue
import { mapGetters } from 'vuex'

computed() {
	...mapGetters(['reverseMessage'])
}

// store.js
getters: {
	reverseMessage(state) {
		return state.msg.split('').reverse().join('');
	}
}
```

```html
<!-- <p>{{ this.$store.getters.reverseMessage }}</p> -->
<p>{{ this.reverseMessage }}</p>
```



### Spread Operator 를 쓰는 이유

- 기존에 컴포넌트 내에 존재하는 `computed` 속성과 `mapGetters`를 함께 사용하기 위해서 ES6 Spread Operator 이용



## mapMutations

### Vuex에 선언한 mutations 속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼

```javascript
// App.vue
import { mapMutations } from 'vuex'

methods: {
	...mapMutations([''])
}

// store.js
mutations: {

}
```

