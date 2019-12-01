<template>
  <div id="app">
    <todo-header></todo-header>
    <todo-input v-on:addTodoItem="addOneItem"></todo-input>
    <todo-list v-bind:propsdata="todoItems" v-on:removeTodoItem="removeOneItem" v-on:toggleTodoItem="toggleOneItem"></todo-list>
    <todo-footer></todo-footer>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoList from './components/TodoList.vue'
import TodoInput from './components/TodoInput.vue'
import TodoFooter from './components/TodoFooter.vue'

// // ES5
// var my_cmp = {
//   template: '<div>my component</div>'
// };

// new Vue({
//   el: '',
//   components: {
//     '컴포넌트 이름': my_cmp
//   }
// });

export default {
  components: {
    // 컴포넌트 태그명 : 컴포넌트 내용
    'TodoHeader': TodoHeader,
    'TodoInput': TodoInput,
    'TodoList': TodoList,
    'TodoFooter': TodoFooter
  },
  data: function() {
    return {
      todoItems: []
    }
  },
  methods: {
    addOneItem: function(todoItem) {
      var obj = { completed: false, item: todoItem};
      localStorage.setItem(todoItem, JSON.stringify(obj));
      this.todoItems.push(obj); // localStorage와 동기화
    },
    removeOneItem: function(todoItem, index) {
     localStorage.removeItem(todoItem.item); // localStorage 아이템 지우기 (브라우저 저장소 영역)
     this.todoItems.splice(index, 1); // 특정 인덱스를 지울 수 있는 자바스크립트 배열 메소드 (스크립트 영역)
    },
    toggleOneItem: function(todoItem, index) {
      todoItem.completed = !todoItem.completed;
      // 로컬 스토리지에 데이터 갱신
      localStorage.removeItem(todoItem.item);
      localStorage.setItem(todoItem.item, JSON.stringify(todoItem));
    }
  },
  created: function() {
    if (localStorage.length > 0) {
      for (var i=0; i < localStorage.length; i++) {
        if (localStorage.key(i) !== 'loglevel:webpack-dev-server') {
          this.todoItems.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
          }
        }
      }
  }

}
</script>

<style>
body {
  text-align: center;
  background-color: #F6F6F6;
}
input {
  border-style: groove;
  width: 200px;
}
button {
  border-style: groove;
}
.shadow {
  box-shadow: 5px 10px 10px rgba(0, 0, 0, 0.03);
}
</style>