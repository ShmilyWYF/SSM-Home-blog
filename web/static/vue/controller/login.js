let tmp ='<div class="login">\n' +
    '    <el-card class="box-card">\n' +
    '      <template #header>\n' +
    '        <div class="card-header">\n' +
    '          <span>用户登录系统</span>\n' +
    '        </div>\n' +
    '      </template>\n' +
    '      <el-form label-width="80px" :model="form" ref="form" :rules="rules">\n' +
    '        <el-form-item label="用户名:" prop="userName">\n' +
    '          <el-input type="text"  v-model="form.userName"></el-input>\n' +
    '        </el-form-item>\n' +
    '        <el-form-item label="密码:" prop="password">\n' +
    '          <el-input type="password"  v-model="form.password"></el-input>\n' +
    '        </el-form-item>\n' +
    '        <el-form-item>\n' +
    '          <el-button type="primary" @click="login(\'form\')">登录</el-button>\n' +
    '        </el-form-item>\n' +
    '      </el-form>\n' +
    '    </el-card>\n' +
    '  </div>'

import {nameRule,pwdRule} from "../../utils/vaildate.js"
import {login} from "../../api/api.js"
import {setToken} from "../../utils/token.js";



const my_login = Vue.component('my-login', {
    template: tmp,
    data() {
        return{
            form:{
                userName: '',
                password: '',
            },
            rules:{
                userName:{validator:nameRule,trigger:'blur'},
                password:{validator:pwdRule,trigger:'blur'},
            },
        };
    },
    mounted(){
        let data=JSON.parse(document.getElementById('map').value)
        let user=data.username;
        let paw=data.password;
        this.$set(this.form,'userName',user)
        this.$set(this.form,'password',paw)
    },
    methods:{
        login(form){
            this.$refs[form].validate((res)=>{
                console.log("res",res)
                 if(res){
                    login(this.form).then((res)=>{

                        let obj=res.data;
                        console.log("obj",obj)
                        if(obj.code==="200"){
                            console.log("登录成功")
                            setToken("username",obj.data.userName);
                            setToken("Token",obj.token);
                            this.$message({message:obj.success,type:obj.message})
                            this.$router.push({ path: this.redirect || '/DataController' })
                        }else {
                            this.$message({message:obj.success,type:obj.message})
                        }
                    })
                }
            })
        }
    }

})

export default my_login;