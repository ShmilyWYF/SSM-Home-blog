let tmp = '<div class="quick-nav">\n' +
    '      <img src="../../static/assets/img/icon/icon2.png" alt="" class="monster">\n' +
    '               <a href="#" target="_blank">\n' +
    '      <img src="../../static/assets/img/icon/icon5.png" alt="" class="readme">\n' +
    '      </a>\n' +
    '      <img src="../../static/assets/img/icon/icon7.png" alt="" class="spark">\n' +
    '    </div>'

const home_quicknav = Vue.component('home-quicknav', {
    template: tmp,
    data() {
        return {}
    },
})

export default home_quicknav;