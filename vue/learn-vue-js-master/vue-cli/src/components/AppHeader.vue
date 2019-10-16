<template>
  <header>
      <h1>
          {{ propsdata }}
      </h1>
      <button v-on:click="sendEvent">send</button>
    </header>
</template>

<script>
export default {
    // 인스턴스 옵션
    props: ['propsdata'],
    methods: {
        sendEvent: function() {
             this.$emit('renew'); // 이벤트 올림
        }
    }

}
</script>

<style>

</style>