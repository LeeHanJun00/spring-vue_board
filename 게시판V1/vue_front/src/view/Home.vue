<template>
  <v-app>
<p>{{$store.state.userId}}님 반갑습니다.</p>
    <v-list lines="one">
      <v-list-item @click="moveToPost(n.board_idx)" v-for="n in postList" :key="n" :title="n.title"></v-list-item>
    </v-list>
    <v-container>
      <v-bottom-navigation>
        <v-btn @click="goWrite" value="favorites">
          <v-icon icon="$vuetify"></v-icon>
          <span>글 작성</span>
        </v-btn>

      </v-bottom-navigation>
    </v-container>
  </v-app>

</template>

<script>

import axios from "axios";
import router from "@/router";
// axios.defaults.baseURL = 'http://localhost:8080';
axios.defaults.withCredentials = true;
export default {
  name: 'App',
  computed: {

  },
  data: () => ({
    username:'',
    postList :[],
    title : 'asdasd',

  }),
  mounted() {
    axios.get("http://localhost:8080/list",{
      headers: {
        "Content-Type": `application/json`,
      },
    }).then((res) => {
      console.log("모든 게시글 조회 성공",res);
      this.postList = res.data

    }).catch(e=>{
      console.log("모든 게시글 조회 실패", e)
    });

},
  methods :{
    goWrite(){
      router.push("/write");
    },

    async moveToPost(board_idx){
      console.log()
      window.location.href =  '/post/' + board_idx

      //TODO GET 요청

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
