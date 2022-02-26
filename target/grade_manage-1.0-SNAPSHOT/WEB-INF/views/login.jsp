<%--
  Created by IntelliJ IDEA.
  User: change
  Date: 2020/12/15
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>

    <% pageContext.setAttribute("APP_PATH", request.getContextPath()); %>

    <script src="${APP_PATH}/static/script/other/jquery-3.1.1.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/css/other/animate.min.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/other/icheck-bootstrap.css">
    <link rel="stylesheet" href="${APP_PATH}/static/css/login/login.css">
    
</head>
<body>

<div class="login-box">
    <h1 class="animated lightSpeedIn" id="hh">
        <span id="mp">Login</span>
    </h1>
    <form action="${APP_PATH}/loginSuccess" method="post" id="user_login">
        <div class="item">
            <input type="text" id="username" name="username" autocomplete="off">
            <span data-placeholder="Username" id="username_error"></span>
        </div>

        <div class="item">
            <input type="password" id="input-password" class="input-password">
            <span data-placeholder="Password" id="password_error"></span>
        </div>

        <input type="hidden" class="md5-password" name="password">

        <div class="id_choose">
            <div class="icheck-primary icheck-inline">
                <input type="radio" value="student" id="chb1" name="identity" checked="checked">
                <label for="chb1">学生</label>
            </div>
            <div class="icheck-primary  icheck-inline">
                <input type="radio" value="teacher" id="chb2" name="identity">
                <label for="chb2">教师</label>
            </div>
            <div class="icheck-primary  icheck-inline">
                <input type="radio" value="admin" id="chb3" name="identity">
                <label for="chb3">管理员</label>
            </div>
        </div>

        <input type="submit" id="sub_btn" class="submit animated rubberBand" value="login" onclick="passPwd()">

    </form>
</div>


<script src="${APP_PATH}/static/script/other/md5.js"></script>
<script src="${APP_PATH}/static/script/login/login.js"></script>
<script type="text/javascript">

    $(function () {
        $("#sub_btn").click(function () {
            send_ajax();
            return false;
        });

        $("#username").focus(function () {
            username_success();
        });
        
        $("#input-password").focus(function () {
            password_success();
        });
    });

    function send_ajax() {
        $.ajax({
            url: "${APP_PATH}/loginCheck",
            type: "post",
            data: $("#user_login").serialize(),
            success: function (result) {
                if (result.code === 200) {
                    login_fail();
                } else if (result.code === 100) {
                   /*跳转到登陆成功页面*/
                    $('#user_login').submit();
                }
            },
            dataType: "json"
        });
    }
    
    function login_fail() {
        $("#username_error").attr("data-placeholder", "Username Error");
        $("#username_error").append("<style>#username_error::before{color:red;}</style>");
        $("#username_error").append("<style>#username_error::after{ background: linear-gradient(150deg, #c9302c, #e2b6c1);}</style>");
        $("#password_error").attr("data-placeholder", "Password Error");
        $("#password_error").append("<style>#password_error::before{color:red}</style>");
        $("#password_error").append("<style>#password_error::after{ background: linear-gradient(150deg, #c9302c, #e2b6c1);}</style>");
    }
    
    function username_success() {
        $("#username_error").attr("data-placeholder", "Username");
        $("#username_error").append("<style>#username_error::before{color:#adadad}</style>");
        $("#username_error").append("<style>#username_error::after{background: linear-gradient(150deg, #10a2ff, #e2b6c1);}</style>");
    }
    
    function password_success() {
        $("#password_error").append("<style>#password_error::before{color:#adadad}</style>");
        $("#password_error").attr("data-placeholder", "Password");
        $("#password_error").append("<style>#password_error::after{background: linear-gradient(150deg, #10a2ff, #e2b6c1);}</style>");
    }
    
</script>

</body>
</html>