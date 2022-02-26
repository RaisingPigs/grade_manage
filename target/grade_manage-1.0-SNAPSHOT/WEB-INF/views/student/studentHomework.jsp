<%--
  Created by IntelliJ IDEA.
  User: change
  Date: 2020/12/20
  Time: 0:59
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
    <link rel="stylesheet" href="${APP_PATH}/static/css/other/table-public.css">
    <link rel="stylesheet" href="${APP_PATH}/static/expr/cssReset.css">
    <link rel="stylesheet" href="${APP_PATH}/static/expr/expr.css">
    <link rel="stylesheet" href="${APP_PATH}/static/expr/iconfont.css">

</head>
<body>

<canvas id="c" style="z-index : -1; position : absolute; display: block;padding:0; margin:0; width: 100%; height: 100%; top: 0; left: 0; overflow: hidden;"></canvas>


<!--导航-->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">学生成绩管理系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="${APP_PATH}/studentIndexControl/${sId}"><span class="glyphicon glyphicon-home"></span> 后台首页</a>
                </li>
                <li>
                    <a href="${APP_PATH}/studentPersonalInfoControl/${sId}"><span
                            class="glyphicon glyphicon-user"></span>
                        个人信息</a>
                </li>
                <li class="active">
                    <a href="${APP_PATH}/studentHomeworkControl/${sId}"><span
                            class="glyphicon glyphicon-list-alt"></span> 个人作业</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <!-- 管理员下拉菜单 -->
                <li id="touxiang">
                    <a class="dropdown-toggle my-dropdown" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"><img src="${APP_PATH}/static/img/admin_head.jpg">
                        &nbsp${student.stuName}&nbsp <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${APP_PATH}/studentPersonalInfoControl/${sId}">&nbsp<span
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


<div class="container">
    <div class="row my-alert">
        <%--成功的提示框--%>
        <div class="alert alert-success text-center" role="alert"><h2></h2></div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="alert alert-info text-center my-alert-nav" role="alert">个 人 作 业 管 理</div>
        </div>
    </div>

    <div class="row">
        <!--左侧导航-->
        <div class="col-md-2">
            <div class="list-group text-center">
                <a href="${APP_PATH}/studentHomeworkControl/${sId}" class="list-group-item active">作业管理</a>
                <a href="${APP_PATH}/studentExperimentControl/${sId}" class="list-group-item">实验管理</a>
                <a href="#" class="list-group-item">其他</a>
            </div>
        </div>

        <!--右侧信息-->
        <div class="col-md-10">
            <div class="common">
                <ul>
                    <c:forEach items="${hwks}" var="item" varStatus="loop">
                        <li class="listbox mr20">
                            <div class="listimg">
                                <a href="${APP_PATH}/studentHomeworkInnerControl/${sId}/${item.hwkId}">
                                    <c:if test="${teachers[loop.count - 1].cName eq 'java'}">
                                        <img src="${APP_PATH}/static/img/java.gif" class="time-img">
                                    </c:if>
                                    <c:if test="${teachers[loop.count - 1].cName eq 'c'}">
                                        <img src="${APP_PATH}/static/img/c.png" class="time-img">
                                    </c:if>
                                    <c:if test="${teachers[loop.count - 1].cName eq 'cpp'}">
                                        <img src="${APP_PATH}/static/img/cpp.jpg" class="time-img">
                                    </c:if>
                                </a>
                                <div class="summary">
                                    <div class="summary-txt">
                                        <p>${item.question}</p>
                                    </div>
                                </div>
                            </div>

                            <div class="list-info">
                                <div class="list-title"><a href="#">${item.question}</a></div>
                                <div class="list-tag"><span class="iconfont icon-fangzi"></span><a href="#">发布老师: ${teachers[loop.count - 1].tchName}</a><a href="#">课程: ${teachers[loop.count - 1].cName}</a></div>
                                <div class="list-date"><span class="iconfont icon-shijian_zhongbiao"></span>2020-12-26
                                </div>
                                
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>

        </div>

    </div>
</div>

<script src="${APP_PATH}/static/script/other/jquery-3.1.1.min.js"></script>
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/static/expr/expr.js"></script>

<script type="text/javascript" src="${APP_PATH}/static/bg/js/TweenMax.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/bg/js/index.js"></script>

</body>
</html>
