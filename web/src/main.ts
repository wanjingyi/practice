import { createApp } from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";
import axios from "axios";
import VueAxios from "vue-axios";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

axios.defaults.baseURL = process.env.VUE_APP_SERVER

const app = createApp(App);
app.use(store).use(router).use(VueAxios, axios).use(ElementPlus).mount("#app");

// 添加请求拦截器
axios.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    console.log('请求参数',config);
    // const token = store.state.user.token;
    // if (Tool.isNotEmpty(token)) {
    //   config.headers.token = token;
    //   console.log("请求headers增加token:", token);
    // }
    return config;
  }, function (error) {
    // 对请求错误做些什么
    console.log('请求错误',error);
    return Promise.reject(error);
  });

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    console.log('返回结果',response);
    return response;
  }, function (error) {
    // 对响应错误做点什么
    console.log('返回错误',error);
    return Promise.reject(error);
  });
