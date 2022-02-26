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
                    <a href="${APP_PATH}/teacherIndexControl/${tId}"><span class="glyphicon glyphicon-home"></span> 后台首页</a>
                </li>
                <li class="active">
                    <a href="${APP_PATH}/teacherStudentInfoControl/${tId}"><span
                            class="glyphicon glyphicon-user"></span>
                        学生管理</a>
                </li>
                <li>
                    <a href="${APP_PATH}/teacherPersonalInfoControl/${tId}"><span class="glyphicon glyphicon-list-alt"></span> 个人信息</a>
                </li>
                <li>
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
                            <a href="${APP_PATH}/teacherPersonalInfoControl/${tId}">&nbsp<span class="glyphicon glyphicon-user"></span> 个人信息 &nbsp</a>
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
    <%--<div class="row my-alert">--%>
        <%--&lt;%&ndash;成功的提示框&ndash;%&gt;--%>
        <%--<div class="alert alert-success text-center" role="alert"><h2></h2></div>--%>
    <%--</div>--%>

    <div class="row">
        <div class="col-md-12">
            <div class="alert alert-info text-center my-alert-nav" role="alert">学 生 信 息 管 理</div>
        </div>
    </div>
    
    <div class="row">
        <!--左侧导航-->
        <div class="col-md-2">
            <div class="list-group text-center">
                <a href="${APP_PATH}/teacherStudentInfoControl/${tId}" class="list-group-item active">学生信息</a>
                <a href="${APP_PATH}/teacherStudentGradeControl/${tId}" class="list-group-item">学生成绩</a>
                <a href="#" class="list-group-item">学生作业</a>
                <a href="#" class="list-group-item">班级信息</a>
                <a href="#" class="list-group-item">课程信息</a>
                <a href="#" class="list-group-item">专业信息</a>
                <a href="#" class="list-group-item">宿舍信息</a>
                <a href="#" class="list-group-item">优秀学生</a>
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

                <%--<div class="col-md-4 pull-right">--%>
                    <%--<button class="btn btn-primary center-block" id="stu_add_modal_btn">新增</button>--%>
                <%--</div>--%>
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
                            <%--<th class="text-center">操作</th>--%>
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

        // remove_error();
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
            var editBtn = $("<button></button>").addClass("btn btn-info btn-sm").append($("<span></span>")).addClass("glyphicon glyphicon-pencil edit_btn").append("编辑");
            //
            // /*为编辑按钮添加一个自定义属性, 用来保存id*/
            // editBtn.attr("edit-id", item.stuId);
            //
            // var delBtn = $("<button></button>").addClass("btn btn-warning btn-sm").append($("<span></span>")).addClass("glyphicon glyphicon-trash del_btn").append("删除");
            //
            // /*为删除按钮添加一个自定义属性, 用来保存id*/
            // delBtn.attr("del-id", item.stuId);
            //
            // var btn = $("<td></td>").addClass("text-center").append(editBtn).append(" ").append(delBtn);

            $("<tr></tr>")
                .append(stuIdTd)
                .append(stuNameTd)
                .append(stuSexTd)
                .append(stuAge)
                .append(stuMajor)
                .append(stuClass)
                // .append(btn)
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
