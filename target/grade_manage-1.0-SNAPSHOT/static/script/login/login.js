"use strict";

$(function () {
    $(".item input").on("focus", function () {
        $(this).addClass("focus");

    });

    $(".item input").on("blur", function () {
        if ($(this).val() === "") {
            $(this).removeClass("focus");
        }
    });

    loginCheck();
});

function loginCheck() {
    /*给注册按钮绑定监听事件*/
    $("#sub_btn").click(function () {
        /*用户名验证*/
        var usernameText = $("#username").val();
        /*获取用户名内容*/
        var usernamePatt = /^\d{5,12}$/;
        /*用来验证用户名的正则表达式*/
        if (!usernamePatt.test(usernameText)) { /*若输入的用户名不符合正则表达式*/
            $("#username_error").attr("data-placeholder", "Username Error");
            // $("#username_error").append("<style>#username_error::before{color:red}</style>");
            $("#username_error").append("<style>#username_error::before{color:red;}</style>");
            $("#username_error").append("<style>#username_error::after{ background: linear-gradient(150deg, #c9302c, #e2b6c1);}</style>");

            /*打印错误信息并不给跳转*/
            return false;
            /*设置了return false时, 就不会跳转*/
        }
        $("#username_error").attr("data-placeholder", "Username");
        $("#username_error").append("<style>#username_error::before{color:#adadad}</style>");
        $("#username_error").append("<style>#username_error::after{background: linear-gradient(150deg, #10a2ff, #e2b6c1);}</style>");
        /*用户名符合正则表达式, 则错误信息清空*/

        /*密码验证*/
        var passwordText = $("#input-password").val();
        var passwordPatt = /^\w{5,12}$/;
        if (!passwordPatt.test(passwordText)) {
            $("#password_error").attr("data-placeholder", "Password Error");
            $("#password_error").append("<style>#password_error::before{color:red}</style>");
            $("#password_error").append("<style>#password_error::after{ background: linear-gradient(150deg, #c9302c, #e2b6c1);}</style>");
            return false;
        }
        $("#password_error").append("<style>#password_error::before{color:#adadad}</style>");
        $("#password_error").attr("data-placeholder", "Password");
        $("#password_error").append("<style>#password_error::after{background: linear-gradient(150deg, #10a2ff, #e2b6c1);}</style>");
    });

}


function passPwd() {
    $(".md5-password").val(hex_md5($(".input-password").val()));
    
    // $(".md5-password").val(md5($(".input-password").val()));
    
    // $(".md5-password").val($(".input-password").val());
}