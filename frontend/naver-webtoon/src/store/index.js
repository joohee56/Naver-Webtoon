import Vue from "vue";
import Vuex from "vuex";
import memberStore from "./modules/memberStore";
import navStore from "./modules/navStore";
import createPersistedState from "vuex-persistedstate";
import Cookies from "js-cookie";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    memberStore,
    navStore,
  },
  plugins: [
    //여기에 쓴 모듈만 cookie에 저장된다.
    createPersistedState({
      paths: ["memberStore"],
      key: "loginUser",
      storage: {
        getItem: (key) => Cookies.get(key),
        setItem: (key, value) => Cookies.set(key, value),
        removeItem: (key) => Cookies.remove(key),
      },
    }),
    //sessionstorage에 저장
    createPersistedState({
      paths: ["navStore"],
      key: "navStore",
      storage: {
        getItem: (key) => sessionStorage.getItem(key),
        setItem: (key, value) => sessionStorage.setItem(key, value),
        removeItem: (key) => sessionStorage.removeItem(key),
      },
    }),
  ],
});
