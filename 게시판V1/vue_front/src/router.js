import { createWebHistory, createRouter } from "vue-router";
import Join from './view/Join.vue'
import Login from './view/Login.vue'
import Home from "./view/Home.vue"
import Write from "@/view/Write.vue";
import Post from "./view/Post.vue";

const routes = [
    {
        path: "/login", // 여기 주소로 들어오면
        component: Login, // 이 화면을 보여주세요
    },
    {
        path: "/join",
        component: Join,
    },
    {
        path: "/home",
        component: Home,
    },
    {
        path: "/write",
        component: Write,
    },
    {
        path: "/post/:boardIdx",
        component: Post,
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router; 