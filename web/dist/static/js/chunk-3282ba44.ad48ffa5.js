(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3282ba44"],{1528:function(e,r,t){"use strict";t("c7f5")},"9ed6":function(e,r,t){"use strict";t.r(r);var o=function(){var e=this,r=e.$createElement,t=e._self._c||r;return t("div",{staticClass:"login"},[t("el-card",{staticClass:"box-card",scopedSlots:e._u([{key:"header",fn:function(){return[t("div",{staticClass:"card-header"},[t("span",[e._v("用户登录系统")])])]},proxy:!0}])},[t("el-form",{ref:"form",attrs:{"label-width":"80px",model:e.form,rules:e.rules,enctype:"application/x-www-form-urlencoded"}},[t("el-form-item",{attrs:{label:"用户名:",prop:"username"}},[t("el-input",{attrs:{type:"text"},model:{value:e.form.username,callback:function(r){e.$set(e.form,"username",r)},expression:"form.username"}})],1),t("el-form-item",{attrs:{label:"密码:",prop:"password"}},[t("el-input",{attrs:{type:"password"},model:{value:e.form.password,callback:function(r){e.$set(e.form,"password",r)},expression:"form.password"}})],1),t("el-form-item",[t("el-button",{attrs:{type:"primary"},on:{click:function(r){return e.login("form")}}},[e._v("登录")])],1)],1)],1)],1)},s=[],a=t("61f7"),n={name:"Login",data:function(){return{form:{username:"",password:""},rules:{username:{validator:a["a"],trigger:"blur"},password:{validator:a["b"],trigger:"blur"}}}},methods:{login:function(e){var r=this;this.$refs[e].validate((function(e){console.log("res",e),e&&r.$store.dispatch("user/login",r.form).then((function(){r.$router.push({path:r.redirect||"/dashboard"})}))}))}}},l=n,i=(t("1528"),t("2877")),u=Object(i["a"])(l,o,s,!1,null,"6553b727",null);r["default"]=u.exports},c7f5:function(e,r,t){}}]);