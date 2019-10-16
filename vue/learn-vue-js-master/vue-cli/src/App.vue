<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> <!--파스칼 케이스-->
    <!--컴포넌트 명명법-->
    <!-- <hello-world></hello-world>
    <HelloWorld></HelloWorld> -->
  </div>
</template>

<script>ㅅ
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'app',
  components: {
    HelloWorld // 'hello-world': HelloWorld 와 동일한 형태이다
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
