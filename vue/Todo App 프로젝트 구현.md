# Todo App 프로젝트 구현

## TodoInput 컴포넌트 내 할 일 저장

```html
<template>
  <div class="inputBox">
      <input type="text" v-model="newTodoItem">
      <button v-on:click="addTodo"></button>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      newTodoItem: ""
    }
  },
  methods: {
    addTodo: function() {
      // this는 TodoInput 컴포넌트
      // console.log(this.newTodoItem);
      // localStorage에 저장하는 로직
      localStorage.setItem(this.newTodoItem, this.newTodoItem);
      this.newTodoItem = '';
    }
  }
}
</script>

<style>
</style>
```



## TodoInput 컴포넌트 코드 정리 및 UI 스타일링

### 메소드 분리 (Todo Item 추가되어 LocalStorage에 저장되는 부분과 data를 초기화하는 부분 분리)

```javascript
 methods: {
    addTodo: function() {
      // this는 TodoInput 컴포넌트
      // console.log(this.newTodoItem);
      // localStorage에 저장하는 로직
      localStorage.setItem(this.newTodoItem, this.newTodoItem);
      this.clearInput();
    },
    clearInput: function() {
      this.newTodoItem = '';
    }
  }
}
```



### 스타일 적용 (하위 스타일 태그)

```javascript
<style scoped>
input:focus {
  outline: none;
}
.inputBox {
  background: white;
  height: 50px;
  line-height: 50px;
  border-radius: 5px;
}
.inputBox input {
  border-style: none;
  font-size: 0.9rem;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, #6478FB, #8763FB);
  display: block;
  width: 3rem;
  border-radius: 0 5px 5px 0;
}
.addBtn {
  color: white;
  vertical-align: middle;
}
</style>
```



### 스타일 적용

- span태그에 addContainer 스타일 적용되도록

```html
<template>
  <div class="inputBox shadow">
      <input type="text" v-model="newTodoItem">
      <!-- <button v-on:click="addTodo"></button> -->
      <!--버튼 스타일링-->
      <span class="addContainer" v-on:click="addTodo">
        <i class="fas fa-plus addBtn"></i>
      </span>
  </div>
</template>
```

- 입력창에서 Enter 키만 입력하여도 바로 localStorage에 저장되도록 (addTodo 함수 호출)

```html
<input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">
```

