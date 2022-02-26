<%--
  Created by IntelliJ IDEA.
  User: change
  Date: 2020/12/20
  Time: 0:33
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
    <link rel="stylesheet" href="${APP_PATH}/static/css/backstageAdmin/backstageAdminIndex/backstageAdminIndex.css">
</head>
<body>

<canvas id="c" style="z-index : -1; position : absolute; display: block;padding:0; margin:0; width: 100%; height: 100%; top: 0; left: 0; overflow: hidden;"></canvas>


<!--导航-->
<nav class="navbar navbar-default  navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="" class="navbar-brand">学生成绩管理系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="${APP_PATH}/backstageIndexAdminControl"><span class="glyphicon glyphicon-home"></span> 后台首页</a>
                </li>
                <li>
                    <a href="${APP_PATH}/backstageAdminStudentInfoControl"><span
                            class="glyphicon glyphicon-user"></span>
                        学生管理</a>
                </li>
                <li>
                    <a href="${APP_PATH}/backstageAdminTeacherInfoControl"><span
                            class="glyphicon glyphicon-book"></span> 教师管理</a>
                </li>
                <li>
                    <a href="${APP_PATH}/backstageAdminStudentPasswordControl"><span
                            class="glyphicon glyphicon-edit"></span> 密码管理</a>
                </li>
                <li>
                    <a href="${APP_PATH}/backstageAdminPersonalInfoControl"><span
                            class="glyphicon glyphicon-list-alt"></span> 个人信息</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <!-- 管理员下拉菜单 -->
                <li id="touxiang">
                    <a class="dropdown-toggle my-dropdown" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"><img src="${APP_PATH}/static/img/admin_head.jpg">
                        管理员 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${APP_PATH}/backstageAdminPersonalInfoControl">&nbsp<span
                                    class="glyphicon glyphicon-user"></span> 个人信息 &nbsp</a>
                        </li>
                        <li>
                            <a href="#">&nbsp<span class="glyphicon glyphicon-pencil"></span> 修改密码 &nbsp</a>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${APP_PATH}/index.jsp">&nbsp
                            <span class="glyphicon glyphicon-log-out"></span> 退出登录 &nbsp</a>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </div>
</nav>

<div>
    <div class="index-bg">
        <img src="${APP_PATH}/static/img/big-bg.png" style="width: 100%;">
    </div>
</div>

<div class="container">

    <div class="row">
        <!--轮播图-->
        <div class="col-md-6">
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
        </div>

        <!--面板-->
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading school-news">校园新闻</div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <a href="#">市教委组织召开党建工作联络员年度交流工作会
                            <small class="pull-right">2020/7/22</small>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="#">我市召开2019年国家义务教育质量监测结果解读会
                            <small class="pull-right">2020/9/15</small>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="#">市语委办组织语言文字工作能力提升培训
                            <small class="pull-right">2020/10/12</small>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="#">正式签署！全球最大自贸协定达成
                            <small class="pull-right">2020/11/08</small>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="#">市教委领导带队赴青海调研教育对口援青工作
                            <small class="pull-right">2020/12/17</small>
                        </a>
                    </li>

                </ul>
            </div>
        </div>
    </div>
</div>

<script src="${APP_PATH}/static/script/other/jquery-3.1.1.min.js"></script>
<script src="${APP_PATH}/static/swiper/swiper.min.js"></script>
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/script/backstageAdmin/backstageAdminIndex/baskstageAdminIndex.js"></script>

<script type="text/javascript" src="${APP_PATH}/static/bg/js/TweenMax.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/bg/js/index.js"></script>

</body>
</html>