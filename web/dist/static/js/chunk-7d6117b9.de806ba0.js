(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7d6117b9"],{"0b6d":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"dashboard-container"},[a(e.currentRole,{tag:"component"})],1)},o=[],i=a("5530"),n=(a("d3b7"),a("159b"),a("caad"),a("2532"),a("2f62")),s=a("5851"),l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-card",[a("el-button",{attrs:{size:"mini",type:"primary"},on:{click:e.adddispachar}},[e._v("add")]),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],staticStyle:{"text-align":"center"},attrs:{data:e.tableData,border:"",fit:!0}},[a("el-table-column",{attrs:{prop:"id",label:"序号",width:"50",align:"center"}}),a("el-table-column",{attrs:{prop:"username",label:"账号",width:"100",align:"center"}}),a("el-table-column",{attrs:{prop:"password",label:"密码",align:"center"}}),a("el-table-column",{attrs:{prop:"name",label:"用户名",align:"center"}}),a("el-table-column",{attrs:{prop:"avatar",label:"头像",align:"center"}}),a("el-table-column",{attrs:{prop:"introduction",label:"说明",align:"center"}}),a("el-table-column",{attrs:{prop:"roles",label:"权限",align:"center"}}),a("el-table-column",{attrs:{label:"操作",width:"180",align:"center",fixed:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"danger",size:"mini",icon:"el-icon-edit"},on:{click:function(a){return e.dialogFormVisible(t.row)}}}),a("el-popover",{attrs:{placement:"top",width:"200"},model:{value:e.visible,callback:function(t){e.visible=t},expression:"visible"}},[a("p",[e._v("确定删除吗？")]),a("div",{staticStyle:{"text-align":"right",margin:"0"}},[a("el-button",{attrs:{size:"mini",type:"text"},on:{click:function(t){e.visible=!1}}},[e._v("取消")]),a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(a){return e.del(t.row)}}},[e._v("确定")])],1),"admin"!==e.name?a("el-button",{staticStyle:{"margin-left":"10px"},attrs:{slot:"reference",type:"danger",size:"mini"},slot:"reference"},[e._v("删除 ")]):e._e()],1)]}}])})],1),a("el-dialog",{attrs:{title:e.state?"编辑用户":"添加用户",visible:e.show,width:"500px"},on:{"update:visible":function(t){e.show=t}}},[a("el-form",{ref:"form",staticClass:"el-form-box",attrs:{model:e.form,rules:e.rules}},[a("el-form-item",{attrs:{label:"序列","label-width":e.formLabelWidth,prop:"id"}},[a("el-input",{attrs:{disabled:""},model:{value:e.form.id,callback:function(t){e.$set(e.form,"id",t)},expression:"form.id"}})],1),a("el-form-item",{attrs:{label:"账号","label-width":e.formLabelWidth,prop:"username"}},[a("el-input",{model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),a("el-form-item",{attrs:{label:"密码","label-width":e.formLabelWidth,prop:"password"}},[a("el-input",{model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1),a("el-form-item",{attrs:{label:"用户名","label-width":e.formLabelWidth,prop:"name"}},[a("el-input",{model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),a("el-form-item",{attrs:{label:"头像","label-width":e.formLabelWidth,prop:"avatar"}},[a("el-input",{model:{value:e.form.avatar,callback:function(t){e.$set(e.form,"avatar",t)},expression:"form.avatar"}})],1),a("el-form-item",{attrs:{label:"说明","label-width":e.formLabelWidth,prop:"introduction"}},[a("el-input",{model:{value:e.form.introduction,callback:function(t){e.$set(e.form,"introduction",t)},expression:"form.introduction"}})],1),a("el-form-item",{attrs:{label:"角色权限","label-width":e.formLabelWidth,prop:"role"}},[a("el-tree",{ref:"tree",attrs:{data:e.data,"show-checkbox":"","default-expand-all":"","node-key":"id","highlight-current":"",props:e.defaultProps}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){return e.closeinfo("form")}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submit("form")}}},[e._v("确 定")])],1)],1)],1)},c=[],d=a("4360"),u=a("c24f"),f={data:function(){var e=this,t=function(t,a,r){var o=e.$refs.tree.getCheckedKeys();0!=o.length&&o?r():r(new Error("请选择功能权限设置"))};return{formLabelWidth:"80px",tableData:[],loading:!0,visible:!1,show:!1,state:!1,name:"",form:{id:0,username:"",password:"",name:"",avatar:"",introduction:"",role:""},rules:{username:[{required:!0,message:"必填属性"}],password:[{required:!0,message:"必填属性"}],name:[{required:!0,message:"必填属性"}],avatar:[{required:!0,message:"必填属性"}],introduction:[{required:!0,message:"必填属性"}],role:[{required:!0,validator:t,trigger:"change"}]},data:[{id:1,label:"admin"},{id:2,label:"editor"},{id:3,label:"user"}],defaultProps:{children:"children",label:"label"}}},mounted:function(){this.getdispachar()},methods:{closeinfo:function(e){this.show=!1,this.$refs[e].resetFields()},getdispachar:function(){var e=this;Object(u["a"])("get","get").then((function(t){setTimeout((function(a){e.loading=!1,console.log(t),t.hasOwnProperty("data")?(e.tableData=t.data.data,e.tableData.forEach((function(e){var t=[],a=JSON.parse(e.role);a.forEach((function(a){"admin"===a.label?t.push("超级管理员"):"editor"===a.label?t.push("编辑者"):t.push("普通用户"),e["roles"]=t}))})),console.log(e.tableData),e.$message({message:"找到"+t.data.data.length+"个用户",type:t.data.type})):(e.tableData=[],e.$message({message:t.data.msg,type:t.data.type}))}),2e3)}))},dialogFormVisible:function(e){this.state=!0,this.show=!0,this.form=Object(i["a"])({},e),this.setCheckedNodes(e.role)},setCheckedNodes:function(e){var t=[],a=JSON.parse(e);function r(e){return e.forEach((function(e){t.push(e.id)})),t}this.$refs.tree.setCheckedKeys(r(a))},adddispachar:function(){this.state=!1,this.show=!0},submit:function(e){var t=this;this.$refs[e].validate((function(e){e&&(t.loading=!0,t.state?(t.form.role=t.$refs.tree.getCheckedNodes(),Object(u["a"])("update","post",t.form).then((function(e){t.$message({message:e.data.msg,type:e.data.type}),t.getdispachar()})),t.show=!1):(t.form.role=t.$refs.tree.getCheckedNodes(),console.log(t.form),Object(u["a"])("add","post",t.form).then((function(e){t.$message({message:e.data.msg,type:e.data.type}),t.getdispachar()})),t.show=!1))}))},del:function(e){var t=this;console.log("del.row:",e),Object(u["a"])("del","post",e).then((function(e){t.loading=!0,t.$message({message:e.data.msg,type:e.data.type}),t.getdispachar()})),this.visible=!1}},created:function(){var e=this;console.log("roles为",this.roles),console.log("打印:",d["a"].getters),d["a"].getters.roles.forEach((function(t){console.log("是否为",t.includes("admin")),e.boolean=t.includes("admin")})),this.boolean?(console.log("用户是admin"),this.currentRole="adminDashboard"):(console.log("用户是editor"),this.currentRole="editorDashboard")}},m=f,p=(a("c5c2"),a("2877")),b=Object(p["a"])(m,l,c,!1,null,"0b96a672",null),h=b.exports,g={name:"Dashboard",components:{dispachar:h,editorDashboard:s["a"]},data:function(){return{currentRole:"dispachar",boolean:!0}},computed:Object(i["a"])(Object(i["a"])({},Object(n["b"])(["roles"])),{},{orderList:function(){return this.$store.state.user.roles}}),created:function(){var e=this;console.log("roles为",this.roles),console.log("打印:",d["a"].getters),d["a"].getters.roles.forEach((function(t){console.log("是否为",t.includes("admin")),e.boolean=t.includes("admin")})),this.boolean?(console.log("用户是admin"),this.currentRole="dispachar"):(console.log("用户是editor"),this.currentRole="editorDashboard")}},v=g,w=Object(p["a"])(v,r,o,!1,null,null,null);t["default"]=w.exports},2900:function(e,t,a){"use strict";a("b707")},"3cbc":function(e,t,a){"use strict";var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"pan-item",style:{zIndex:e.zIndex,height:e.height,width:e.width}},[a("div",{staticClass:"pan-info"},[a("div",{staticClass:"pan-info-roles-container"},[e._t("default")],2)]),a("div",{staticClass:"pan-thumb",style:{backgroundImage:"url("+e.image+")"}})])},o=[],i=(a("a9e3"),{name:"PanThumb",props:{image:{type:String,required:!0},zIndex:{type:Number,default:1},width:{type:String,default:"150px"},height:{type:String,default:"150px"}}}),n=i,s=(a("7443"),a("2877")),l=Object(s["a"])(n,r,o,!1,null,"08b9a4ee",null);t["a"]=l.exports},5851:function(e,t,a){"use strict";var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"dashboard-editor-container"},[a("div",{staticClass:" clearfix"},[a("pan-thumb",{staticStyle:{float:"left"},attrs:{image:e.avatar}},[e._v(" Your roles: "),e._l(e.roles,(function(t){return a("span",{key:t,staticClass:"pan-info-roles"},[e._v(e._s(t))])}))],2),a("github-corner",{staticStyle:{position:"absolute",top:"0px",border:"0",right:"0"}}),a("div",{staticClass:"info-container"},[a("span",{staticClass:"display_name"},[e._v(e._s(e.name))]),a("span",{staticStyle:{"font-size":"20px","padding-top":"20px",display:"inline-block"}},[e._v("编辑仪表盘")])])],1)])},o=[],i=a("5530"),n=a("2f62"),s=a("3cbc"),l=a("f168"),c={name:"DashboardEditor",components:{PanThumb:s["a"],GithubCorner:l["a"]},data:function(){return{}},computed:Object(i["a"])({},Object(n["b"])(["name","avatar","roles"]))},d=c,u=(a("2900"),a("2877")),f=Object(u["a"])(d,r,o,!1,null,"1de73592",null);t["a"]=f.exports},"635a":function(e,t,a){},"6e19":function(e,t,a){},7443:function(e,t,a){"use strict";a("6e19")},a1ca:function(e,t,a){},a9e3:function(e,t,a){"use strict";var r=a("83ab"),o=a("da84"),i=a("94ca"),n=a("6eeb"),s=a("5135"),l=a("c6b6"),c=a("7156"),d=a("c04e"),u=a("d039"),f=a("7c73"),m=a("241c").f,p=a("06cf").f,b=a("9bf2").f,h=a("58a8").trim,g="Number",v=o[g],w=v.prototype,C=l(f(w))==g,y=function(e){var t,a,r,o,i,n,s,l,c=d(e,!1);if("string"==typeof c&&c.length>2)if(c=h(c),t=c.charCodeAt(0),43===t||45===t){if(a=c.charCodeAt(2),88===a||120===a)return NaN}else if(48===t){switch(c.charCodeAt(1)){case 66:case 98:r=2,o=49;break;case 79:case 111:r=8,o=55;break;default:return+c}for(i=c.slice(2),n=i.length,s=0;s<n;s++)if(l=i.charCodeAt(s),l<48||l>o)return NaN;return parseInt(i,r)}return+c};if(i(g,!v(" 0o1")||!v("0b1")||v("+0x1"))){for(var x,_=function(e){var t=arguments.length<1?0:e,a=this;return a instanceof _&&(C?u((function(){w.valueOf.call(a)})):l(a)!=g)?c(new v(y(t)),a,_):y(t)},k=r?m(v):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),N=0;k.length>N;N++)s(v,x=k[N])&&!s(_,x)&&b(_,x,p(v,x));_.prototype=w,w.constructor=_,n(o,g,_)}},b707:function(e,t,a){},ba58:function(e,t,a){"use strict";a("635a")},c5c2:function(e,t,a){"use strict";a("a1ca")},f168:function(e,t,a){"use strict";var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("a",{staticClass:"github-corner",staticStyle:{"z-index":"98"},attrs:{href:"#",target:"_blank","aria-label":"View source on Github"}},[a("svg",{staticStyle:{fill:"#40c9c6",color:"#fff"},attrs:{width:"80",height:"80",viewBox:"0 0 250 250","aria-hidden":"true"}},[a("path",{attrs:{d:"M0,0 L115,115 L130,115 L142,142 L250,250 L250,0 Z"}}),a("path",{staticClass:"octo-arm",staticStyle:{"transform-origin":"130px 106px"},attrs:{d:"M128.3,109.0 C113.8,99.7 119.0,89.6 119.0,89.6 C122.0,82.7 120.5,78.6 120.5,78.6 C119.2,72.0 123.4,76.3 123.4,76.3 C127.3,80.9 125.5,87.3 125.5,87.3 C122.9,97.6 130.6,101.9 134.4,103.2",fill:"currentColor"}}),a("path",{staticClass:"octo-body",attrs:{d:"M115.0,115.0 C114.9,115.1 118.7,116.5 119.8,115.4 L133.7,101.6 C136.9,99.2 139.9,98.4 142.2,98.6 C133.8,88.0 127.5,74.4 143.8,58.0 C148.5,53.4 154.0,51.2 159.7,51.0 C160.3,49.4 163.2,43.6 171.4,40.1 C171.4,40.1 176.1,42.5 178.8,56.2 C183.1,58.6 187.2,61.8 190.9,65.4 C194.5,69.0 197.7,73.2 200.1,77.6 C213.8,80.2 216.3,84.9 216.3,84.9 C212.7,93.1 206.9,96.0 205.4,96.6 C205.1,102.4 203.0,107.8 198.3,112.5 C181.9,128.9 168.3,122.5 157.7,114.1 C157.9,116.9 156.7,120.9 152.7,124.9 L141.0,136.5 C139.8,137.7 141.6,141.9 141.8,141.8 Z",fill:"currentColor"}})])])},o=[],i=(a("ba58"),a("2877")),n={},s=Object(i["a"])(n,r,o,!1,null,"01a93ce5",null);t["a"]=s.exports}}]);