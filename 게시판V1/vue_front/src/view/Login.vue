<template>
  <v-sheet class="mx-auto" width="300">
    <v-form @submit.prevent="btnLogin">
      <v-text-field v-model="id" :rules="rules" label="ID"></v-text-field>
      <v-text-field v-model="pw" :rules="rules" label="PW"></v-text-field>
      <v-btn class="mt-2" type="submit" block>로그인</v-btn>
    </v-form>
    <div>
      <v-btn class="mt-2" color="green" href="/join" block>회원가입</v-btn>
    </div>
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
    id: '',
    pw: '',
    rules: [
      value => {
        if (value) return true

        return '입력해주세요'
      },
    ],
  }),
  methods :{

    async btnLogin() {
      const userData = {
        id: this.id,
        pw: this.pw
      };

      await axios.post("http://localhost:8080/login", userData,{
        headers: {
          "Content-Type": `application/json`,
        },
      }).then((res) => {
        console.log(res)
        if(res.data === "ok") {
          router.push("/home");
          this.$store.commit("setUserId", this.id )
        }else {
          //로그인 실패
          console.log("로그인 실패")
        }
      }).catch(e=>{
        console.log("실패", e)
      });
    }
  },

  components: {
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
