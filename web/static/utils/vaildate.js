export function nameRule(rules,value,callback){
    let reg=/(^[a-zA-Z,\d]{4,16}$)/
    if(value===''){
        callback(new Error("请输入用户名"))
    }else if(!reg.test(value)){
        callback(new Error("请输入4-10位用户名"))
    }else {
        callback();
    }
}
export function pwdRule(rules,value,callback){
    let reg = /^\S*(?=\S{6,})(?=\S*\d)(?=\S*[A-Z])(?=\S*[a-z])\S*$/
    if(value===''){
        callback(new Error("请输入密码"))
    }else if(!reg.test(value)){
        callback(new Error("请输入6-12位密码需要包含大小写字母"))
    }else {
        callback()
    }
}