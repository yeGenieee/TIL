# TodoList

## TodoList 컴포넌트의 할 일 목록 표시 기능 구현

- Emmet을 이용하여 ul태그, li 태그 생성

  ```html
  ul>li*3
  ```

- 결과

  ```html
  <ul>
    <li></li>
    <li></li>
    <li></li>
  </ul>
  ```



### created

- Vue 라이프사이클 중, **인스턴스가 생성되자마자 호출되는 라이프사이클 훅**

![image-20191023145253458](/Users/yegenieee/Desktop/Github_TIL/TIL/image/13_vue_lifecycle.png)

```javascript
created: function() {
	// console.log('created');
}
```



## Data 개수 만큼 화면에 뿌리기

### v-for 이용

- `v-bind:key` 를 이용하여 key값이 (여기선 todoItem) 중복되지 않으면 반복문의 성능을 향상시킴

```html
<li v-for="todoItem in todoItems" v-bind:key="todoItem"></li>
```

