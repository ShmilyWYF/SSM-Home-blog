import getAxios from "../js/getAxios.js";

export function login(data){
    return getAxios({
        method:'post',
        url:'/login',
        data:JSON.stringify(data)
    })
}

export function getBlog(){
    return getAxios({
        method:'get',
        url:'/dispatcher/blog',
        params: {
            methodName: 'get'
        }
    })
}