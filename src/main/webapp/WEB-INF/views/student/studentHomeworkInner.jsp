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
                <a href="${APP_PATH}/studentHomeworkControl/${sId}" class="list-group-item active">个人信息</a>
                <a href="${APP_PATH}/studentExperimentControl/${sId}" class="list-group-item">实验管理</a>
                <a href="#" class="list-group-item">其他</a>
            </div>
        </div>

        <!--右侧信息-->
        <div class="col-md-5 col-md-offset-2">
            <div class="panel panel-default text-center">
                <div class="panel-heading school-news">${hwk.question}</div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <textarea id="answer" name="answer" rows="10" cols="55" placeholder="请输入答案"></textarea>
                    </li>
                    <li class="list-group-item grade_p">
                        <p style="margin: 0;">本次作业得分: <span class="grade"></span></p>
                    </li>
                </ul>
            </div>

            <button class="btn btn-info my-submit" style="width: 458px; height: 40px;">提交作业</button>
        </div>
    </div>
</div>

<script src="${APP_PATH}/static/script/other/jquery-3.1.1.min.js"></script>
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${APP_PATH}/static/bg/js/TweenMax.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/bg/js/index.js"></script>

<script>
    $(function () {
        $.ajax({
            url: "${APP_PATH}/getHwkAnswer/" + ${sId} +"/" + ${hwkId},
            type: "get",
            success: function (result) {
                if (result.extend.hwk.answer !== "") {
                    $("#answer").val(result.extend.hwk.answer);
                    $("#answer").attr("readonly", true);
                    $(".my-submit").attr("disabled", true);
                }else {
                    $(".grade_p").hide();
                }

                if (result.extend.hwk.hwkGrd !== 0) {
                    $(".grade").text(result.extend.hwk.hwkGrd);
                } else {
                    $(".grade").text("未批阅");
                }

                if (result.extend.hwk.hwkGrd < 60 && result.extend.hwk.hwkGrd !== 0) {
                    $("#answer").attr("readonly", false);
                    $(".my-submit").attr("disabled", false);
                    $(".grade").append(" (不及格请重做)");
                }
            }
        })
    });

    $(".my-submit").click(function () {
        if (confirm("确定要提交作业吗?")) {
            $.ajax({
                url: "${APP_PATH}/updateHwkAnswer/${sId}/${hwkId}",
                type: "put",
                data: $("#answer"),
                success: function (result) {
                    if (result.code === 100) {
                        $(".my-alert > div > h2").text("提交成功!");
                        $(".my-alert").show(1000, function () {
                            $(".my-alert").hide(2000);
                        });

                        $(".grade").text("未批阅");
                        $(".grade_p").show();
                        $(".my-submit").attr("disabled", true);
                        $("#answer").attr("readonly", true);
                    }
                }
            })
        }
    });


</script>


</body>
</html>
