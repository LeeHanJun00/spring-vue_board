import { createStore } from 'vuex'
import persistedstate from 'vuex-persistedstate';

const store = createStore({
    state() {
        return {
            userId: '',
        }

    },
    mutations: {
        setUserId(state, userId){
            state.userId = userId;
        }
    },
    plugins: [
    persistedstate({
        paths: ['userId']
    })
],
});

export default store;