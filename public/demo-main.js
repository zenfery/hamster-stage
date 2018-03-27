// demo 页面的入口

import Vue from "vue";

import VueI18n from "vue-i18n";
Vue.use(VueI18n);

import Demo from "./components/demo/demo.vue";

const messages = {
    "zh_CN":{},
    "en_US":{}
};

const i18n = new VueI18n({
    locale: "zh_CN",
    fallbackLocale: "zh_CN",
    messages: messages
});


var demo = new Vue({
    el: "#main",
    components: {Demo},
    template: "<Demo />",
    i18n: i18n
});
