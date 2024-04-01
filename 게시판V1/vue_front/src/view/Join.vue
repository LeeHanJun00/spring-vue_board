<template>
  <v-sheet class="mx-auto" width="300">
    <v-form  @submit.prevent="btnJoin()">
      <v-text-field v-model="name" :rules="rules" label="NAME"></v-text-field>
      <v-text-field v-model="id" :rules="rules" label="ID"></v-text-field>
      <v-text-field v-model="pw" :rules="rules" label="PW"></v-text-field>
      <v-btn class="mt-2" color="green" block type="submit">회원가입</v-btn>
    </v-form>
    <v-btn class="mt-2" color="black" href="/login" block>돌아가기</v-btn>
  </v-sheet>
</template>

<script>
import axios from "axios";
import router from "../router";
// axios.defaults.baseURL = 'http://localhost:8080';
axios.defaults.withCredentials = true;
export default {
  name: 'App',

  data: () => ({
    name: '',
    id: '',
    pw: '',
    rules: [
      value => {
        if (value) return true
        return '입력해주세요'
      },
    ],
  }),
  methods: {
  async btnJoin() {

    const userData = {
      name: this.name,
      id: this.id,
      pw: this.pw
    };

  await axios.post("http://localhost:8080/join",  JSON.stringify(userData), {
    headers: {
      "Content-Type": `application/json`,
    },
       }).then((res) => {
          console.log("회원가입 성공",res);
          router.push("/login");
        }).catch(e=>{
          console.log("회원가입 실패", e)
        });
    }

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>