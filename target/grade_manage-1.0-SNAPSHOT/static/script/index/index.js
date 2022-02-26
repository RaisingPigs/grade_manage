$(function () {
    lunBo();
});

function lunBo() {
    /*参数1: 容器(#box)*/
    /*参数2: 配置项*/
    new Swiper(".banner", {
        autoplay: {
            delay: 3000,
            disableOnInteraction: false
        },
        
        loop: true, /*loop: 循环播放*/

        pagination: {
            el: ".swiper-pagination" /*分页器(下面的点)*/
        },

        navigation: {
            prevEl: ".swiper-button-prev",
            nextEl: ".swiper-button-next"  /*前进后退箭头*/
        }
    });
}
