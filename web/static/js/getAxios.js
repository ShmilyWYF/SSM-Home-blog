import {getToken} from "../utils/token.js";

const service=axios.create({
    headers: {
        'Content-Type': 'application/json;charset=UTF-8'
    },
    baseURL:'http://localhost:8080/',
    timeout: 1000,
})


//添加请求拦截器
service.interceptors.request.use(config=>{
    config.headers['token']=getToken("Token")
    console.log("config:",config)
    return config
},(error)=>{
    return Promise.reject(error)
})

//添加响应拦截器
service.interceptors.response.use(response=> {
        let {code,message}=response.data
        if(code !== 200){
            console.log(message)
        }
        return response
    }, error => {
        console.log('拦截器 response error ')
        console.log(error)
        if(error.request){
            console.log(error.request)
        } else if(error.response){
            console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);
        }
        if (error && error.response) {
            switch (error.response.status) {
                case 400: error.message = "请求错误(400)" ; break;
                case 401: error.message = "未授权，请重新登录(401)"; break;
                case 403: error.message = "拒绝访问(403)"; break;
                case 404: error.message = "请求出错(404)"; break;
                case 408: error.message = "请求超时(408)"; break;
                case 500: error.message = "服务器错误(500)"; break;
                case 501: error.message = "服务未实现(501)"; break;
                case 502: error.message = "网络错误(502)"; break;
                case 503: error.message = "服务不可用(503)"; break;
                case 504: error.message = "网络超时(504)"; break;
                case 505: error.message = "HTTP版本不受支持(505)"; break;
            }
        }else{
            error.message = "连接服务器失败"
            console.log(error)
            error.data={
                code:500,
                type:error
            }
        }
        return error
    }
)
export  default service