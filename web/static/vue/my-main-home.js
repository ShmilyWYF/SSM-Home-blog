import my_aside from "../../static/vue/main_home/my-aside.js";
import home_mains from "../../static/vue/main_home/my-mains.js";
import home_quicknav from "../../static/vue/main_home/my-quicknav.js";
import home_update from "../../static/vue/main_home/my-update.js";
import home_footer from "../../static/vue/main_home/my-footer.js";

let tmp = '                 <el-container>\n' +
    '                        <el-aside width="200px" style="overflow: revert">\n' +
    '                           <el-row :gutter="8" style="height: 100%;">\n' +
    '                               <el-col :xs="{span: 24}" :sm="{span: 24}" :md="{span: 24}" :lg="{span: 24}" :xl="{span: 24}">\n' +
    '                                   <home-aside/>\n' +
    '                                </el-col>\n' +
    '                             </el-row>\n' +
    '                        </el-aside>\n' +
    '                        <el-container>\n' +

    '                                    <el-main style="padding: 0;">\n' +
    '                                       <home-mains id="header-div"/>\n' +
    '                                       <home-quicknav/>\n' +
    '                                       <home-update id="update-card"/>\n' +
    '                                       <home-footer id="home-footer"/>\n' +
    '                                    </el-main>\n' +

    '                        </el-container>\n' +
    '                    </el-container>'

const main_home = Vue.component('my-main-home', {
    template: tmp,
    data() {
        return {}
    },
})

export default main_home;