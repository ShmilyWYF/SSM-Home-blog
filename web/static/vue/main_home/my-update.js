
let tmp = '<div class="my-update" style="width: 80%;margin: 1% auto;text-align: left">' +
    '<el-card class="box-card">\n' +
    '    <div slot="header" class="clearfix">\n' +
    '      <span style="font-weight: bold;font-size: 20px">最近更新</span>\n' +
    '    </div>\n' +
    '    <div class="block">\n' +
    '           <el-timeline :reverse="reverse">\n' +
    '               <el-timeline-item v-for="(activity, index) in activities" :key="index" :timestamp="activity.t_time">\n' +
    '                   <el-card>' +
    '                     <p>{{activity.t_body}}</p>' +
    '                   </el-card>\n' +
    '               </el-timeline-item>\n' +
    '               <p v-if="activities===null">暂无任何记录</p>\n' +
    '           </el-timeline>\n' +
    '    </div>\n' +
    '  </el-card>\n' +
    '</div>'

import {getBlog} from "../../api/api.js";
const home_update = Vue.component('home-update', {
    template: tmp,
    data(){
        return {
            reverse: true,
            activities: [],
        };
    },
    mounted(){
        this.queryallBlog()
    },
    methods:{
        queryallBlog(){
            getBlog().then(res=>{
                console.log(res)
                if(res.data.code===200){
                    this.activities=res.data.data;
                    this.$message({message:res.data.msg,type:res.data.type})
                }else {
                    this.$message({message:res.message,type:res.type})
                }
            })
        }
    }
})

export default home_update;