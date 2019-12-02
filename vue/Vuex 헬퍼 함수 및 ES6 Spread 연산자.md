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

    