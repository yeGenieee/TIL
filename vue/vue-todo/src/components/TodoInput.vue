<template>
  <div class="inputBox shadow">
      <input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">
      <!-- <button v-on:click="addTodo"></button> -->
      <!--버튼 스타일링-->
      <span class="addContainer" v-on:click="addTodo">
        <i class="fas fa-plus addBtn"></i>
      </span>

    <modal v-if="showModal" @close="showModal = false">
      <h3 slot="header">경고!
        <i class="fas fa-times" @click="showModal = false"></i>
      </h3>
      <h3 slot="body">아무것도 입력하지 않으셨습니다.</h3>
    </modal>
  </div>
</template>

<script>
import Modal from './common/Modal.vue'

export default {
  data: function() {
    return {
      newTodoItem: "",
      showModals: false
    }
  },
  methods: {
    addTodo: function() {
      if (this.newTodoItem !== '') {
        // this.newTodoItem만 상위 컴포넌트로 보내줄 수 있도록 함
        // this.$emit('addTodoItem', this.newTodoItem);
        const text = this.newTodoItem.trim(); // 앞 뒤 공백 제거
        this.$store.commit('addOneItem', text);
        this.clearInput();
      } else {
        this.showModals = !this.showModals;
      }
    },
    clearInput: function() {
      this.newTodoItem = '';
    }
  },
  components: {

  }
}
</script>

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