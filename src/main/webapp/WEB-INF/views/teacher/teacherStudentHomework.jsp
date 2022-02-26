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
                <h4 class="modal-title text-center">查看作业</h4>
            </div>
            <div class="modal-body">

                <%--模态框的内嵌表单--%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="stuName_update_input" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10" id="stuName_update_div">
                            <input type="text" class="form-control disabled" id="stuName_update_input"
                                   autocomplete="off"
                                   placeholder="输入新的学生姓名" data-toggle="tooltip" title="用户名必须是2-5位中文!" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">专业</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="stuMajor_update_select" readonly="readonly">
                                <option value="计算机">计算机</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">班级</label>
                        <div class="col-sm-3">
                            <select class="form-control" id="stuClass_update_select" readonly="readonly">
                                <option value="2001">2001</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">问题</label>
                        <div class="col-sm-10" id="question_div">
                            <textarea id="question_input" rows="3" cols="62" readonly="readonly"></textarea>
                        </div>


                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">答案</label>
                        <div class="col-sm-10" id="answer_div">
                            <textarea id="answer_input" rows="5" cols="62" readonly="readonly"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">成绩</label>
                        <div class="col-sm-10" id="exprGrd_div">
                            <input type="text" class="form-control disabled" name="hwkGrd" id="exprGrd_input"
                                   autocomplete="off" 
                                   placeholder="输入新的学生本次实验的成绩" data-toggle="tooltip" title="成绩必须在0-100">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="stu_update_btn">修改</button>
                    </div>
                </form>
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
                    <a href="${APP_PATH}/teacherIndexControl/${tId}"><span class="glyphicon glyphicon-home"></span> 后台首页</a>
                </li>
                <li>
                    <a href="${APP_PATH}/teacherStudentInfoControl/${tId}"><span
                            class="glyphicon glyphicon-user"></span>
                        学生管理</a>
                </li>
                <li>
                    <a href="${APP_PATH}/teacherPersonalInfoControl/${tId}"><span class="glyphicon glyphicon-list-alt"></span>
                        个人信息</a>
                </li>
                <li class="active">
                    <a href="${APP_PATH}/teacherHomeworkControl/${tId}"><span class="glyphicon glyphicon-list-alt"></span> 作业发布</a>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <!-- 管理员下拉菜单 -->
                <li id="touxiang">
                    <a class="dropdown-toggle my-dropdown" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="false"><img src="${APP_PATH}/static/img/admin_head.jpg">
                        &nbsp${teacher.tchName}&nbsp <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${APP_PATH}/teacherPersonalInfoControl/${tId}">&nbsp<span
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
            <div class="alert alert-info text-center my-alert-nav" role="alert">学 生 作 业 管 理</div>
        </div>
    </div>

    <div class="row">
        <!--左侧导航-->
        <div class="col-md-2">
            <div class="list-group text-center">
                <a href="${APP_PATH}/teacherHomeworkControl/${tId}" class="list-group-item active">作业管理</a>
                <a href="${APP_PATH}/teacherExperimentControl/${tId}" class="list-group-item ">实验管理</a>
                <a href="#" class="list-group-item">其他</a>
            </div>
        </div>

        <!--右侧信息-->
        <div class="col-md-10">

            <div class="row my-search-div">
                <div class="col-md-6">
                    <div class="col-lg-6 pull-left">
                        <div class="input-group my-search">
                            <input type="text" class="form-control" placeholder="请输入姓名">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button">搜索</button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover table-striped" id="stu_table">
                        <%--存放表头--%>
                        <thead>
                        <tr>
                            <th class="text-center">学号</th>
                            <th class="text-center">姓名</th>
                            <th class="text-center">性别</th>
                            <th class="text-center">年龄</th>
                            <th class="text-center">专业</th>
                            <th class="text-center">班级</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>

                        <%--存放数据--%>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>

            <%--分页条--%>
            <div class="row">
                <div class="col-md-6 col-md-offset-4" id="page_nav_area">

                </div>
            </div>

            <%--分页信息--%>
            <div class="row my-page-info bg-primary">
                <div class="col-md-3 col-md-offset-2" id="page_num">
                    <span></span>
                </div>
                <div class="col-md-3" id="page_total">
                    <span></span>
                </div>
                <div class="col-md-3" id="count_total">
                    <span></span>
                </div>
            </div>

        </div>

    </div>
</div>

<script src="${APP_PATH}/static/script/other/jquery-3.1.1.min.js"></script>
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="${APP_PATH}/static/bg/js/TweenMax.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/static/bg/js/index.js"></script>

<script>
    var totalRecord, currentPage;
    var stuName = "";

    $(function () {
        to_page(1);

        remove_error();
    });

    function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/stus",
            data: "pn=" + pn,
            type: "get",
            success: function (result) {
                /*1. 成功后在页面解析json, 显示数据*/
                build_stu_table(result);
                /*2. 解析并显示分页信息*/
                build_page_info(result);
                /*分页条*/
                build_page_nav(result);
            },
            dataType: "json"
        });
    }

    function build_stu_table(result) {
        /*开局清空table*/
        $("#stu_table tbody").empty();

        /*获取学生数据放到stus中*/
        var stus = result.extend.pageInfo.list;
        /*遍历 $.each(遍历的集合, 每次遍历的回调函数)*/
        $.each(stus, function (index, item) { /*下标和下标对应的信息*/
            /*创建员工信息的td*/
            var stuIdTd = $("<td></td>").addClass("text-center").append(item.stuId);
            var stuNameTd = $("<td></td>").addClass("text-center").append(item.stuName);
            var stuSexTd = $("<td></td>").addClass("text-center").append(item.stuSex);
            var stuAge = $("<td></td>").addClass("text-center").append(item.stuAge);
            var stuMajor = $("<td></td>").addClass("text-center").append(item.stuMajor);
            var stuClass = $("<td></td>").addClass("text-center").append(item.stuClass);
            var editBtn = $("<button></button>").addClass("btn btn-info btn-sm").append($("<span></span>")).addClass("glyphicon glyphicon-list-alt edit_btn").append(" 作业");

            /*为编辑按钮添加一个自定义属性, 用来保存id*/
            editBtn.attr("edit-id", item.stuId);

            var btn = $("<td></td>").addClass("text-center").append(editBtn);

            $("<tr></tr>")
                .append(stuIdTd)
                .append(stuNameTd)
                .append(stuSexTd)
                .append(stuAge)
                .append(stuMajor)
                .append(stuClass)
                .append(btn)
                .appendTo("#stu_table tbody");
            /*将信息添加到table的tbody中*/
        });
    }

    function build_page_info(result) {
        /*开局清空分页信息*/
        $("#page_num span").empty();
        $("#page_total span").empty();
        $("#count_total span").empty();

        $("#page_num span").append("当前为第 " + result.extend.pageInfo.pageNum + " 页");
        $("#page_total span").append("总共 " + result.extend.pageInfo.pages + " 页");
        $("#count_total span").append("总共 " + result.extend.pageInfo.total + " 条记录");

        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }

    function build_page_nav(result) {
        /*开局清空分页条*/
        $("#page_nav_area").empty();

        var ul = $("<ul></ul>").addClass("pagination my-page");

        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").attr("aria-label", "Previous").attr("href", "#").append("<span></span>").append("&laquo;").attr("aria-hidden", "true"));

        /*没有上一页时, 让上一页和首页消失/无法点击*/
        if (!result.extend.pageInfo.hasPreviousPage) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            /*可以点击时, 才绑定点击事件*/

            /*首页单击事件跳转*/
            firstPageLi.click(function () {
                if (stuName === "") {
                    to_page(1);
                } else {
                    to_search_page(1, stuName);
                }
            });

            /*上一页单击事件跳转*/
            prePageLi.click(function () {
                if (stuName === "") {
                    to_page(result.extend.pageInfo.pageNum - 1);
                } else {
                    to_search_page(result.extend.pageInfo.pageNum - 1, stuName);
                }
            });
        }

        ul.append(firstPageLi).append(prePageLi);

        var nextPageLi = $("<li></li>").append($("<a></a>").attr("aria-label", "Next").attr("href", "#").append("<span></span>").append("&raquo;").attr("aria-hidden", "true"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));

        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));

            /*当前页对应的页号变为不可点击*/
            if (item === result.extend.pageInfo.pageNum) {
                numLi.addClass("active");
            }

            /*每一页单击事件跳转*/
            numLi.click(function () {
                if (stuName === "") {
                    to_page(item);
                } else {
                    to_search_page(item, stuName);
                }
            });

            ul.append(numLi);
        });

        /*没有下一页时, 让下一页和末页消失/无法点击*/
        if (!result.extend.pageInfo.hasNextPage) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            /*可以点击时, 才绑定点击事件*/

            /*末页单击事件跳转*/
            lastPageLi.click(function () {
                if (stuName === "") {
                    to_page(result.extend.pageInfo.pages);
                } else {
                    to_search_page(result.extend.pageInfo.pages, stuName);
                }

            });

            /*下一页单击事件跳转*/
            nextPageLi.click(function () {
                if (stuName === "") {
                    to_page(result.extend.pageInfo.pageNum + 1);
                } else {
                    to_search_page(result.extend.pageInfo.pageNum + 1, stuName);
                }
            });
        }

        ul.append(nextPageLi).append(lastPageLi);

        var navEle = $("<nav></nav>").append(ul);

        navEle.appendTo("#page_nav_area");
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
            }
        });


        $.ajax({
            url: "${APP_PATH}/getHwkQuestion/" + id + "/${hwkId}",
            type: "get",
            success: function (result) {
                var stuData = result.extend.homework;
                $("#question_input").val(stuData.question === "" ? "尚无实验" : stuData.question);
                $("#answer_input").val(stuData.answer === "" ? "该学生未完成作业" : stuData.answer);
                $("#exprGrd_input").val(stuData.hwkGrd === 0 ? "" : stuData.hwkGrd);
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
            url: "${APP_PATH}/updateHwkGrade/" + $(this).attr("edit-id") + "/${hwkId}",
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
        var stuAge = $("#exprGrd_input").val();
        var regAge = /^(?:[1-9][0-9]?|1[01][0-9]|100)$/;
        if (!regAge.test(stuAge)) {
            $("#exprGrd_div").addClass("has-error");
            $("#exprGrd_input").tooltip("show");
            return false;
        }
        return true;
    }

    /*文本发生改变时, 移除错误的css*/
    function remove_error() {
        $('#exprGrd_input').bind('input propertychange change', function () {
            $("#exprGrd_div").removeClass("has-error");
            $('#exprGrd_input').tooltip("destroy");
        });
    }
    
    /*搜索*/
    $(".my-search > span > button").click(function () {
        stuName = $(this).parent("span").prev().val();
        if (stuName === "") {
            to_page(1);
        } else {
            to_search_page(1, stuName);
        }
    });

    function to_search_page(pn, stuName) {
        $.ajax({
            url: "${APP_PATH}/searchStu/" + stuName + "/" + pn,
            type: "get",
            success: function (result) {
                console.log(result);
                /*1. 成功后在页面解析json, 显示数据*/
                build_stu_table(result);
                /*2. 解析并显示分页信息*/
                build_page_info(result);
                /*分页条*/
                build_page_nav(result);
            }
        });
    }

    /*搜索回车单击*/
    $(".my-search input").keydown(function () {
        if (event.keyCode === 13) {
            $(".my-search > span > button").click();
            $(".my-search input").blur();
        }
    });
</script>


</body>
</html>
