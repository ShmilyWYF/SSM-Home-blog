import home from "../vue/my-main-home.js"
// import login from "../vue/controller/login.js"

let one={template:'<div>one</div>'}
let blog={template:'<div>blog</div>',beforeCreate(){window.location.href="http://localhost:8080/blogindex"}}
let login={template:'<div>login</div>',beforeCreate(){window.location.href="http://localhost:8080/login"}}

export default new VueRouter({
    mode:'history',
    routes:[
        {
            path:'/home',
            component: home,
        },
        {
            path:'/one',
            component:one
        },
        {
            path:'/blogindex',
            component:blog
        },
        {
            path: '/login',
            component: login,
        },
    ]
})