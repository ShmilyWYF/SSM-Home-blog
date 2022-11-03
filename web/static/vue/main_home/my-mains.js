let tmp =' ' +
    '<el-card class="card-carousel" style="width: 80%;margin: auto;" :body-style="{height:\'100%\'}">\n' +
    '     <el-carousel  :interval="4000" arrow="always">\n' +
    '         <el-carousel-item v-for="item in items" :key="item.id" stylet="">\n' +
    '               <a :href=item.link target="_blank">\n' +
    '                     <img :src=item.img alt="" class="carousel_img">\n' +
    '               </a>\n' +
    '             <h3 style="font-size: 100%">{{item.title}}</h3>\n' +
    '         </el-carousel-item>\n' +
    '     </el-carousel>\n' +
    ' </el-card>'


const home_mains = Vue.component('home-mains', {
    template: tmp,
    data() {
        return {
            items: [
                {
                    id: 1,
                    title: 'How2J.cn - Java 全栈学习网站',
                    img: '../../static/images/home_main/how2j.png',
                    link: 'http://how2j.cn?p=50613'
                },
                {
                    id: 2,
                    title: 'Vue.js - 渐进式 JavaScript 框架',
                    img: '../../static/images/home_main/vue.png',
                    link: 'https://cn.vuejs.org/'
                },
                {
                    id: 3,
                    title: 'element-ui - 网站快速成型工具',
                    img: '../../static/images/home_main/element.png',
                    link: 'http://element-cn.eleme.io/#/zh-CN'
                }
                ]
        }
    },
})

export default home_mains;