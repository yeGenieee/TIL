<template>
    <div>
        <ul>
            <li v-for="(todoItem, index) in this.storedTodoItems" v-bind:key="todoItem.item" class="shadow">
                <i class="checkBtn fas fa-check" v-bind:class="{checkBtnCompleted: todoItem.completed }" 
                v-on:click="toggleComplete(todoItem, index)"></i>
                <span v-bind:class="{textCompleted: todoItem.completed}"> {{ todoItem.item }} </span>
                <span class="removeBtn" v-on:click="removeTodo(todoItem, index)">
                    <i class="fas fa-trash-alt"></i>
                </span>
            </li>
        </ul>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
    methods: {
        removeTodo: function(todoItem, index) {
            // this.$emit('removeTodoItem', todoItem, index);
            // const obj = {
            //     todoItem: todoItem,
            //     index: index
            // }
            // ES6에서 key - value가 같으면, 단축 가능
            const obj = {
                todoItem,
                index
            }
            this.$store.commit('removeOneItem', { todoItem, index });
        },
        toggleComplete: function(todoItem, index) {
            // this.$emit('toggleTodoItem', todoItem, index);
            this.$store.commit('toggleOneItem', { todoItem, index });
        }
    },
    computed: {
        ...mapGetters(['storedTodoItems'])
        // spread Operator 이용 시, 템플릿 내 객체명과 getters 명이 다를 때, 객체로 사용
        // ...mapGetters({
        //     todoItems: 'storedTodoItems'
        // })
    }
}
</script>

<style scoped>
ul {
    list-style-type: none;
    padding-left: 0px;
    margin-top: 0;
    text-align: left;
}
li {
    display: flex;
    min-height: 50px;
    height: 50px;
    line-height: 50px;
    margin: 0.5rem 0;
    padding: 0 0.9rem;
    background: white;
    border-radius: 5px;
}
.checkBtn {
    line-height: 45px;
    color: #62acde;
    margin-right: 5px;
}
.checkBtnCompleted {
    color: #b3adad;
}
.textCompleted {
    text-decoration: line-through;
    color: #b3adad;
}
.removeBtn {
    margin-left: auto;
    color: #de4343;
}
</style>