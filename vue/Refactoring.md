# Refactoring

![image-20191129_Improved_Application_Structure](../image/6_10_Improved_Structure.png)

- 변경된 구조로 리팩토링



## 할 일 목록 표시 기능

- 변경된 구조를 위해 TodoList.vue에서 관리하던 todoItems를 App.vue에서 관리하도록 함

- App.vue (TodoList.vue에서 관리했던 todoItems를 이곳에서 관리)

  ```javascript
  data: function() {
      return {
        todoItems: []
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
  ```

  

- App.vue에서 관리하는 todoItems 컴포넌트 데이터를 TodoList.vue로 내려보내주어야 함

  - 이 때 사용하는 것이 `v-bind`

    ```html
    <todo-list v-bind:내려보낼 프롭스 속성 이름="현재 위치의 컴포넌트 데이터 속성"></todo-list>
    ```

    ```html
    <todo-list v-bind:propsdata="todoItems"></todo-list>
    ```

  - 그리고, 내려보낼 프롭스 속성을 받아줄 하위 컴포넌트에 `props` 속성 명시 (TodoList.vue)

    ```javascript
    export default {
      ...
    	props: ['propsdata'],
      ...
    }
    ```



