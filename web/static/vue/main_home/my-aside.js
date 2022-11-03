let tmp = '                       <div class="my-aside">' +
    '                               <el-card>\n' +
    '                                <el-menu :default-active="active_aside" class="el-menu-vertical-demo" active-text-color="#ff0000">\n' +
    '                                   <a href="#header-div">\n' +
    '                                    <el-menu-item index="1">\n' +
    '                                        <i class="el-icon-menu"></i>\n' +
    '                                        <span slot="title">技术采用</span>\n' +
    '                                    </el-menu-item>\n' +
    '                                  </a>\n' +
    '                                  <a href="#update-card">\n' +
    '                                    <el-menu-item index="2">\n' +
    '                                        <i class="el-icon-menu"></i>\n' +
    '                                        <span slot="title">最近更新</span>\n' +
    '                                    </el-menu-item>\n' +
    '                                  </a>\n' +
    '                                  <a href="#">\n' +
    '                                    <el-menu-item index="3">\n' +
    '                                        <i class="el-icon-document"></i>\n' +
    '                                        <span slot="title">下载源码</span>\n' +
    '                                    </el-menu-item>\n' +
    '                                  </a>\n' +
    '                                  <a href="#home-footer">\n' +
    '                                    <el-menu-item index="4">\n' +
    '                                        <i class="el-icon-setting"></i>\n' +
    '                                        <span slot="title">关于我</span>\n' +
    '                                    </el-menu-item>\n' +
    '                                  </a>\n' +
    '                                </el-menu>\n' +
    '                            </el-card>' +
    '                           </div>'

const home_aside = Vue.component('home-aside', {
    template: tmp,
    data() {
        return {
            active_aside: "1",
        }
    },
})

export default home_aside;