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


<%--学生修改的模态框--%>
<div class="modal fade" id="stuUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title text-center">修改学生</h4>
            </div>
            <div class="modal-body">

                <%--模态框的内嵌表单--%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="stuName_update_input" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10" id="stuName_update_div">
                            <input type="text" class="form-control " name="stuName" id="stuName_update_input"
                                   autocomplete="off"
                                   placeholder="输入新的学生姓名" data-toggle="tooltip" title="用户名必须是2-5位中文!">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="stuSex" id="stuSex1_update_input" value="男" checked="checked">
                                男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="stuSex" id="stuSex2_update_input" value="女"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuAge_update_input" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-10" id="stuAge_update_div">
                            <input type="text" class="form-control" name="stuAge" id="stuAge_update_input"
                                   placeholder="输入新的学生年龄" autocomplete="off" data-toggle="tooltip" title="年龄格式不正确!">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">专业</label>
                        <div class="col-sm-3">
                            <select class="form-control" name="dId" id="stuMajor_update_select">
                                <option value="计算机">计算机</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">班级</label>
                        <div class="col-sm-3">
                            <select class="form-control" name="dId" id="stuClass_update_select">
                                <option value="2001">2001</option>
                            </select>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="stu_update_btn">修改</button>
            </div>
        </div>
    </div>
</div>

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
                <li class="active">
                    <a href="${APP_PATH}/studentPersonalInfoControl/${sId}"><span
                            class="glyphicon glyphicon-user"></span>
                        个人信息</a>
                </li>
                <li>
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
                            <a href="#">&nbsp<span class="glyphicon glyphicon-user"></span> 个人信息 &nbsp</a>
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
            <div class="alert alert-info text-center my-alert-nav" role="alert">个 人 信 息 管 理</div>
        </div>
    </div>

    <div class="row">
        <!--左侧导航-->
        <div class="col-md-2">
            <div class="list-group text-center">
                <a href="#" class="list-group-item active">个人信息</a>
                <a href="#" class="list-group-item">其他</a>
            </div>
        </div>

        <!--右侧信息-->
        <div class="col-md-5 col-md-offset-2">
            <div class="panel panel-default text-center">
                <div class="panel-heading school-news">学生信息</div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <span>学号: </span>
                        <span class="stu_id"></span>
                    </li>
                    <li class="list-group-item">
                        <span>姓名: </span>
                        <span class="stu_name"></span>
                    </li>
                    <li class="list-group-item">
                        <span>性别: </span>
                        <span class="stu_sex"></span>
                    </li>
                    <li class="list-group-item">
                        <span>年龄: </span>
                        <span class="stu_age"></span>
                    </li>
                    <li class="list-group-item">
                        <span>专业: </span>
                        <span class="stu_major"></span>
                    </li>
                    <li class="list-group-item">
                        <span>班级: </span>
                        <span class="stu_class"></span>
                    </li>
                    <li class="list-group-item">
                        <span>java: </span>
                        <span class="java_grade"></span>
                    </li>
                    <li class="list-group-item">
                        <span>c: </span>
                        <span class="c_grade"></span>
                    </li>
                    <li class="list-group-item">
                        <span>cpp: </span>
                        <span class="cpp_grade"></span>
                    </li>
                </ul>
            </div>
            
            <%--<button class="btn btn-info" style="width: 458px; height: 40px;">修改信息</button>--%>
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
          url:"${APP_PATH}/getStu/${sId}",
          type:"get",
          success:function (result) {
              console.log(result);
              $(".stu_id").text(result.extend.stu.stuId);
              $(".stu_name").text(result.extend.stu.stuName);
              $(".stu_sex").text(result.extend.stu.stuSex);
              $(".stu_age").text(result.extend.stu.stuAge);
              $(".stu_major").text(result.extend.stu.stuMajor);
              $(".stu_class").text(result.extend.stu.stuClass);
              $(".java_grade").text(result.extend.stu.grades[0].java);
              $(".c_grade").text(result.extend.stu.grades[0].c);
              $(".cpp_grade").text(result.extend.stu.grades[0].cpp);
          }
        })
    });

    /*文本发生改变时, 移除错误的css*/
    function remove_error() {
        $('#stuName_update_input').bind('input propertychange change', function () {
            $("#stuName_update_div").removeClass("has-error");
            $('#stuName_update_input').tooltip("destroy");
        });
    }

    /*编辑按钮的单击事件*/
    /*由于按钮是动态生成的, 所以要用on方法来绑定*/
    $(document).on("click", ".edit_btn", function () {
        /*查出当前员工信息*/
        getStu($(this).attr("edit-id"));

        /*把员工id传递给模态框的更新按钮*/
        $("#stu_update_btn").attr("edit-id", $(this).attr("edit-id"));
        /*弹出模态框*/
        $("#stuUpdateModal").modal({
            backdrop: "static" /*点击背景模态框不消失*/
        });
    });

    function getStu(id) {
        $.ajax({
            url: "${APP_PATH}/getStu/" + id,
            type: "get",
            success: function (result) {
                var stuData = result.extend.stu;
                $("#stuName_update_input").val(stuData.stuName);

                /*单选框和下拉列表, 要用[]*/
                $("#stuUpdateModal input[name=stuSex]").val([stuData.stuSex]);

                $("#stuAge_update_input").val(stuData.stuAge);
            }
        });
    }

    /*模态框的修改按钮的点击事件*/
    $("#stu_update_btn").click(function () {
        /*校验修改表单的数据*/
        if (!validate_update_form()) {
            return false;
        }

        /*发送ajax请求保存数据*/
        $.ajax({
            url: "${APP_PATH}/updateStu/" + $(this).attr("edit-id"),
            type: "put",
            data: $("#stuUpdateModal form").serialize(),
            success: function (result) {
                /*关闭模态框*/
                $("#stuUpdateModal").modal("hide");
                /*回到本页面*/
                /*currentPage定义为全局变量, 构建分页条时赋值*/
                if (stuName === "") {
                    to_page(currentPage);
                } else {
                    to_search_page(currentPage, stuName);
                }

            }
        });

        $(".my-alert > div > h2").text("修改成功!");
        $(".my-alert").show(1000, function () {
            $(".my-alert").hide(2000);
        });
    });

    /*校验修改表单的数据*/
    function validate_update_form() {
        /*拿到需要校验的数据*/
        var stuName = $("#stuName_update_input").val();
        /*字母大小写以及数字下划线横杠 5-16位, 或者2-5位的中文*/
        var regName = /^[\u2E80-\u9FFF]{2,5}/;
        if (!regName.test(stuName)) {
            $("#stuName_update_div").addClass("has-error");
            $("#stuName_update_input").tooltip("show");
            return false;
        }

        var stuAge = $("#stuAge_update_input").val();
        var regAge = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
        if (!regAge.test(stuAge)) {
            $("#stuAge_update_div").addClass("has-error");
            $("#stuAge_update_input").tooltip("show");
            return false;
        }
        return true;
    }

</script>


</body>
</html>
