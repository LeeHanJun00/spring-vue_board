<template>
  <v-container style="max-width: 500px ">
    <h2>{{$store.state.userId}}님의 글 작성</h2>
    <v-form  >
      <v-text-field v-model="title" label="제목" variant="outlined" readonly></v-text-field>
      <v-textarea  v-model="content" label="내용" variant="outlined" readonly></v-textarea>
    </v-form>
  </v-container>
</template>

<script>

import axios from "axios";
// import router from "@/router";

// axios.defaults.baseURL = 'http://localhost:8080';
axios.defaults.withCredentials = true;
export default {
  name: 'App',
  data: () => ({
    title: '',
    content: ''
  }),
  mounted() {
    // const board_idx = this.$route.params.boardIdx;
    axios.get(`http://localhost:8080/post/${this.$route.params.boardIdx}`,{
      headers: {
        "Content-Type": `application/json`,
      },
    }).then((res) => {
      console.log(" 게시글 조회 성공",res);
      this.title = res.data.title;
      this.content = res.data.content;

    }).catch(e=>{
      console.log(" 게시글 조회 실패", e)
    });
  },
  methods: {


  },

  components: {}
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
