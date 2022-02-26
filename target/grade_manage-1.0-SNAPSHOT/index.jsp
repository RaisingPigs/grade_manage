<%--
  Created by IntelliJ IDEA.
  User: change
  Date: 2020/12/19
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <title>首页</title>

    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

    <link rel="stylesheet" href="${APP_PATH}/static/swiper/swiper.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <!--自定义的写下面才能覆盖-->
    <link rel="stylesheet" href="${APP_PATH}/static/css/index/index.css">

</head>
<body>

<!--导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand text-center">学生成绩管理系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" id="home_login">学校首页</a></li>
                <li><a href="#">学校新闻</a></li>
                <li><a href="#">院系设置</a></li>
                <li><a href="#">科学研究</a></li>
                <li><a href="#">招生就业</a></li>
                <li><a href="${APP_PATH}/myLogin" id="login">登录系统</a></li>
            </ul>
        </div>
    </div>
</nav>

<section id="home">
    <!--轮播容器 (需设置swiper-container属性值)-->
    <div class="banner swiper-container">
        <!--图片模块  (需设置swiper-wrapper属性值)-->
        <div class="imgs swiper-wrapper">
            <!--图片的a标签  (需设置swiper-slide属性值)-->
            <a href="#" class="swiper-slide"><img src="${APP_PATH}/static/img/index_swiper1.jpg"></a>
            <a href="#" class="swiper-slide"> <img src="${APP_PATH}/static/img/index_swiper2.jpg"></a>
            <a href="#" class="swiper-slide"> <img src="${APP_PATH}/static/img/index_swiper3.jpg"></a>
            <a href="#" class="swiper-slide"> <img src="${APP_PATH}/static/img/index_swiper4.jpg"></a>
            <a href="#" class="swiper-slide"> <img src="${APP_PATH}/static/img/index_swiper5.jpg"></a>
        </div>

        <!--分页器(下面的点)-->
        <div class="swiper-pagination"></div>

        <!--前进后退箭头-->
        <div class="swiper-button-prev swiper-button-white"></div>
        <div class="swiper-button-next swiper-button-white"></div>
    </div>
</section>


<script src="${APP_PATH}/static/script/other/jquery-3.1.1.min.js"></script>
<script src="${APP_PATH}/static/swiper/swiper.min.js"></script>
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/script/index/index.js"></script>

</body>
</html>