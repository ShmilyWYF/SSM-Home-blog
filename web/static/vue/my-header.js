let tmp = '               <el-card style="border: 0" :body-style="{padding:\'0\'}">\n' +
    '                        <el-menu :default-active="active_header" class="el-menu-demo" mode="horizontal" @select="handleSelect">\n' +
    '                            <el-menu-item index="home">首页</el-menu-item>\n' +
    '                            <el-menu-item index="one">图书馆</el-menu-item>\n' +
    '                            <el-menu-item index="blogindex">图书馆</el-menu-item>\n' +
    '                            <el-menu-item index="login">图书馆</el-menu-item>\n' +
    // '                            <template>' +
    // '                               <el-menu-item index="blogindex">' +
    // '                                  <a href="http://localhost:8080/blogindex" target="_self">博客</a>' +
    // '                               </el-menu-item>\n' +
    // '                               <el-menu-item index="login">' +
    // '                                  <a href="http://localhost:8080/login" target="_self">管理中心</a>' +
    // '                               </el-menu-item>\n' +
    // '                            </template>\n' +
    '                        </el-menu>\n' +
    '                    </el-card>'

Vue.component('my-header', {
    template: tmp,
    data() {
        return {
            active_header:'',
            keywords:null,
            key:'',
        }
    },
    mounted(){
        let data= document.getElementById('urlval').value;
        this.active_header=data;
        this.key=data;
    },
    methods: {
        handleSelect(key) {
            console.log(key)
            if(key!==this.key){
                this.$message({message:"欢迎来到"+key,type:"success"})
                this.key=key;
                this.$router.push("/" + key)
            }else {
                this.$message({message:"目前正在浏览"+key+"页面",type:"warning"})
            }
        },
    }
});
