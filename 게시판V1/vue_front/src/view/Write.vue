<template>
  <v-container style="max-width: 500px ">
    <h2>{{$store.state.userId}}님의 글 작성</h2>
    <v-form  @submit.prevent="write">
    <v-text-field v-model="title" label="제목" variant="outlined"></v-text-field>
    <v-textarea  v-model="content" label="내용" variant="outlined"></v-textarea>
    <v-btn class="mt-2" color="blue" type="submit" block>작성 완료</v-btn>
    </v-form>
  </v-container>
</template>

<script>

import axios from "axios";
import router from "@/router";
// axios.defaults.baseURL = 'http://localhost:8080';
axios.defaults.withCredentials = true;
export default {
  name: 'App',
  data: () => ({
    title:'',
    content : ''
  }),
  mounted() {
  },
  methods :{
    async write() {
      const writeData = {
        userId : this.$store.state.userId,
        title: this.title,
        content: this.content
      };

      await axios.post("http://localhost:8080/write", writeData,{
        headers: {
          "Content-Type": `application/json`,
        },
      }).then((res) => {
        console.log(res)
        if(res.data === "ok") {
          router.push("/home");
        }else {
          //로그인 실패
          console.log("작성 실패")
        }
      }).catch(e=>{
        console.log("실패", e)
      });
    },

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
