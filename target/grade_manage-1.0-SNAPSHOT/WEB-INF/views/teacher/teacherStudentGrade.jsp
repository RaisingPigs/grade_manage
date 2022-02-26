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
                <h4 class="modal-title text-center">修改成绩</h4>
            </div>
            <div class="modal-body">

                <%--模态框的内嵌表单--%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="stuId_update_input" class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="sId" id="stuId_update_input"
                                   autocomplete="off" placeholder="" readonly>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="stuName_update_input" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10" id="stuName_update_div">
                            <input type="text" class="form-control" name="stuName" id="stuName_update_input"
                                   autocomplete="off" placeholder="" readonly>
                        </div>
                    </div>

                    <div class="form-group disabled">
                        <label for="stuClass_update_input" class="col-sm-2 control-label">班级</label>
                        <div class="col-sm-10" id="stuClass_update_div">
                            <input type="text" class="form-control" name="stuAge" id="stuClass_update_input"
                                   placeholder="" autocomplete="off" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="java_update_input" class="col-sm-2 control-label">平时成绩</label>
                        <div class="col-sm-10" id="java_update_div">
                            <input type="text" class="form-control" name="" id="java_update_input"
                                   placeholder="输入平时成绩" autocomplete="off" data-toggle="tooltip" title="成绩格式不正确!" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="c_update_input" class="col-sm-2 control-label">考试成绩</label>
                        <div class="col-sm-10" id="c_update_div">
                            <input type="text" class="form-control" name="" id="c_update_input"
                                   placeholder="输入考试成绩" autocomplete="off" data-toggle="tooltip" title="成绩格式不正确!">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cpp_update_input" class="col-sm-2 control-label">实验成绩</label>
                        <div class="col-sm-10" id="cpp_update_div">
                            <input type="text" class="form-control" name="" id="cpp_update_input"
                                   placeholder="输入实验成绩" autocomplete="off" data-toggle="tooltip" title="成绩格式不正确!" readonly>
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


<%--学生增加的模态框--%>
<div class="modal fade" id="stuAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title text-center" id="myModalLabel" data-toggle="tooltip" data-placement="bottom"
                    title="成绩占比总和必须为100!">修改成绩占比</h4>
            </div>
            <div class="modal-body">

                <%--模态框的内嵌表单--%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="stuName_add_input" class="col-sm-2 control-label">平时成绩</label>
                        <div class="col-sm-10" id="stuName_add_div">
                            <input type="text" class="form-control " name="usualGrd" id="stuName_add_input"
                                   autocomplete="off"
                                   placeholder="输入平时成绩占比" data-toggle="tooltip" title="成绩占比应在0-100!">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="stuAge_add_input" class="col-sm-2 control-label">考试成绩</label>
                        <div class="col-sm-10" id="stuAge_add_div">
                            <input type="text" class="form-control" name="examGrd" id="stuAge_add_input"
                                   placeholder="输入考试成绩占比" autocomplete="off" data-toggle="tooltip" title="成绩占比应在0-100!">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="expr_add_input" class="col-sm-2 control-label">实验成绩</label>
                        <div class="col-sm-10" id="expr_add_div">
                            <input type="text" class="form-control" name="exprGrd" id="expr_add_input"
                                   placeholder="输入实验成绩占比" autocomplete="off" data-toggle="tooltip" title="成绩占比应在0-100!">
                        </div>
                    </div>

                    <p class="text-center alert-grd-pct" style="font-weight: bold"> &nbsp (注: 平时成绩占比 + 考试成绩占比 + 实验成绩占比 =
                        100%)</p>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="stu_save_btn">保存</button>
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
                <li class="active">
                    <a href="${APP_PATH}/teacherStudentInfoControl/${tId}"><span
                            class="glyphicon glyphicon-user"></span>
                        学生管理</a>
                </li>
                <li>
                    <a href="${APP_PATH}/teacherPersonalInfoControl/${tId}"><span class="glyphicon glyphicon-list-alt"></span>
                        个人信息</a>
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
            <div class="alert alert-info text-center my-alert-nav" role="alert">学 生 成 绩 管 理</div>
        </div>
    </div>

    <div class="row">
        <!--左侧导航-->
        <div class="col-md-2">
            <div class="list-group text-center">
                <a href="${APP_PATH}/teacherStudentInfoControl/${tId}" class="list-group-item">学生信息</a>
                <a href="${APP_PATH}/teacherStudentGradeControl/${tId}" class="list-group-item active">学生成绩</a>
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

                <div class="col-md-3 pull-right">
                    <button class="btn btn-primary center-block" id="stu_add_modal_btn">成绩占比</button>
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
                            <th class="text-center">班级</th>
                            <th class="text-center">${teacher.cName}</th>
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
            var stuSexTd = $("<td></td>").addClass("text-center").append(item.stuClass);
            var stuAge = $("<td></td>").addClass("text-center").append(item.grades[0].${teacher.cName});
            var editBtn = $("<button></button>").addClass("btn btn-info btn-sm").append($("<span></span>")).addClass("glyphicon glyphicon-pencil edit_btn").append("编辑");

            /*为编辑按钮添加一个自定义属性, 用来保存id*/
            editBtn.attr("edit-id", item.stuId);

            /*var delBtn = $("<button></button>").addClass("btn btn-warning btn-sm").append($("<span></span>")).addClass("glyphicon glyphicon-trash del_btn").append("删除");

            /!*为删除按钮添加一个自定义属性, 用来保存id*!/
            delBtn.attr("del-id", item.stuId);*/

            var btn = $("<td></td>").addClass("text-center").append(editBtn);

            $("<tr></tr>")
                .append(stuIdTd)
                .append(stuNameTd)
                .append(stuSexTd)
                .append(stuAge)
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

    /*点击新增按钮弹出模态框*/
    $("#stu_add_modal_btn").click(function () {
        /*清空表单数据*/
        /*用dom对象的reset()方法*/
        // $("#stuAddModal form")[0].reset();

        getGrdPct();

        /*弹出模态框*/
        $("#stuAddModal").modal({
            backdrop: "static" /*点击背景模态框不消失*/
        });
    });

    /*获取成绩占比*/
    function getGrdPct() {
        $.ajax({
            url: "${APP_PATH}/getGrdPct/",
            type: "get",
            success: function (result) {
                var stuData = result.extend.grdPct;
                $("#stuName_add_input").val(stuData.usualGrd);
                $("#stuAge_add_input").val(stuData.examGrd);
                $("#expr_add_input").val(stuData.exprGrd);
            }
        });
    }


    /*新增模态框中的保存按钮的单击事件*/
    $("#stu_save_btn").click(function () {
        /*先对数据进行校验*/
        /*校验成功后进行保存*/
        if (!validate_add_form()) {
            return false;
        }

        /*将模态框中填写的表单数据提交给服务器进行保存*/
        $.ajax({
            url: "${APP_PATH}/saveGrdPct",
            type: "post",
            data: $("#stuAddModal form").serialize(),
            success: function (result) {
                /*保存成功后, 关闭模态框*/
                $("#stuAddModal").modal("hide");
            },
            dataType: "json"
        });

        $(".my-alert > div > h2").text("保存成功!");
        $(".my-alert").show(1000, function () {
            $(".my-alert").hide(2000);
        });
    });

    /*校验增加表单的数据*/
    function validate_add_form() {
        /*拿到需要校验的数据*/
        var stuName = $("#stuName_add_input").val();
        /*字母大小写以及数字下划线横杠 5-16位, 或者2-5位的中文*/
        var regName = /^(?:[1-9][0-9]?|1[01][0-9]|100)$/;
        if (!regName.test(stuName)) {
            $("#stuName_add_div").addClass("has-error");
            $("#stuName_add_input").tooltip("show");
            return false;
        }

        var stuAge = $("#stuAge_add_input").val();
        var regAge = /^(?:[1-9][0-9]?|1[01][0-9]|100)$/;
        if (!regAge.test(stuAge)) {
            $("#stuAge_add_div").addClass("has-error");
            $("#stuAge_add_input").tooltip("show");
            return false;
        }

        var expr = $("#expr_add_input").val();
        var regExpr = /^(?:[1-9][0-9]?|1[01][0-9]|100)$/;
        if (!regExpr.test(expr)) {
            $("#expr_add_div").addClass("has-error");
            $("#expr_add_input").tooltip("show");
            return false;
        }

        if (parseInt(stuName) + parseInt(stuAge) + parseInt(expr) !== 100) {
            $("#myModalLabel").tooltip("show");
            return false;
        }
        return true;
    }

    /*文本发生改变时, 移除错误的css*/
    function remove_error() {
        $('#stuAge_add_input').bind('input propertychange change', function () {
            $("#stuAge_add_div").removeClass("has-error");
            $('#stuAge_add_input').tooltip("destroy");
            $("#myModalLabel").tooltip("destroy");
        });

        $('#stuName_add_input').bind('input propertychange change', function () {
            $("#stuName_add_div").removeClass("has-error");
            $('#stuName_add_input').tooltip("destroy");
            $("#myModalLabel").tooltip("destroy");
        });

        $('#expr_add_input').bind('input propertychange change', function () {
            $("#expr_add_div").removeClass("has-error");
            $('#expr_add_input').tooltip("destroy");
            $("#myModalLabel").tooltip("destroy");
        });

        $('#java_update_input').bind('input propertychange change', function () {
            $("#java_update_div").removeClass("has-error");
            $('#java_update_input').tooltip("destroy");
        });

        $('#c_update_input').bind('input propertychange change', function () {
            $("#c_update_div").removeClass("has-error");
            $('#c_update_input').tooltip("destroy");
        });

        $('#cpp_update_input').bind('input propertychange change', function () {
            $("#cpp_update_div").removeClass("has-error");
            $('#cpp_update_input').tooltip("destroy");
        });
    }

    /*编辑按钮的单击事件*/
    /*由于按钮是动态生成的, 所以要用on方法来绑定*/
    $(document).on("click", ".edit_btn", function () {
        /*查出当前学生信息*/
        getStu($(this).attr("edit-id"));

        /*把学生id传递给模态框的更新按钮*/
        $("#stu_update_btn").attr("edit-id", $(this).attr("edit-id"));

        /*获取学生作业成绩*/
        getHwkGrd($(this).attr("edit-id"));

        /*获取学生实验成绩*/
        getExprGrd($(this).attr("edit-id"));

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
                $("#stuId_update_input").val(stuData.stuId);
                $("#stuName_update_input").val(stuData.stuName);
                $("#stuClass_update_input").val(stuData.stuClass);
            }
        });
    }

    function getHwkGrd(id) {
        $.ajax({
            url: "${APP_PATH}/getHwkGrd/" + id + "/${tId}",
            type: "get",
            success: function (result) {
                $("#java_update_input").val(result.extend.hwkGrd === 0 ? "" : result.extend.hwkGrd);
            }
        })
    }

    function getExprGrd(id) {
        $.ajax({
            url: "${APP_PATH}/getExprGrd/" + id + "/${tId}",
            type: "get",
            success: function (result) {
                $("#cpp_update_input").val(result.extend.exprGrd === 0 ? "" : result.extend.exprGrd);
            }
        })
    }

    /*模态框的修改按钮的点击事件*/
    $("#stu_update_btn").click(function () {
        /*校验修改表单的数据*/
        if (!validate_update_form()) {
            return false;
        }

        var javaGrade;

        var id = $(this).attr("edit-id");

        $.ajax({
            url: "${APP_PATH}/getGrdPct",
            type: "get",
            success: function (result) {
                // console.log(result);
                var usualPct = parseInt(result.extend.grdPct.usualGrd) * 0.01;
                var examPct = parseInt(result.extend.grdPct.examGrd) * 0.01;
                var exprPct = parseInt(result.extend.grdPct.exprGrd) * 0.01;
                var usualGrade = parseInt($("#java_update_input").val());
                var examGrade = parseInt($("#c_update_input").val());
                var exprGrade = parseInt($("#cpp_update_input").val());
                
                javaGrade = Math.round(usualPct * usualGrade + examPct * examGrade + exprPct * exprGrade);
                
                /*发送ajax请求保存数据*/
                $.ajax({
                    url: "${APP_PATH}/updateGrade/" + id + "/" + javaGrade + "/${tId}",
                    type: "put",
                    success: function (result) {
                        if (result.code === 100) {
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
                    }
                });

            }
        });

        $(".my-alert > div > h2").text("修改成功!");
        $(".my-alert").show(1000, function () {
            $(".my-alert").hide(2000);
        });
    });

    /*校验修改表单的数据*/
    function validate_update_form() {
        var java = $("#java_update_input").val();
        var c = $("#c_update_input").val();
        var cpp = $("#cpp_update_input").val();
        var regAge = /^([0-9][0-9]{0,1}|100)$/;
        if (!regAge.test(java)) {
            $("#java_update_div").addClass("has-error");
            $("#java_update_input").tooltip("show");
            return false;
        }
        if (!regAge.test(c)) {
            $("#c_update_div").addClass("has-error");
            $("#c_update_input").tooltip("show");
            return false;
        }
        if (!regAge.test(cpp)) {
            $("#cpp_update_div").addClass("has-error");
            $("#cpp_update_input").tooltip("show");
            return false;
        }
        return true;
    }

    <%--/*删除学生的按钮点击事件*/--%>
    <%--$(document).on("click", ".del_btn", function () {--%>
    <%--/*弹出是否删除对话框*/--%>
    <%--/*找删除按钮的所有父元素的tr, 再找tr的第二个td子元素*/--%>
    <%--var stuName = $(this).parents("tr").find("td:eq(1)").text();--%>
    <%--var stuId = $(this).attr("del-id");--%>
    <%--if (confirm("确定删除 " + stuName + " 吗?")) {--%>
    <%--$.ajax({--%>
    <%--url: "${APP_PATH}/deleteStu/" + stuId,--%>
    <%--type: "delete",--%>
    <%--success: function (result) {--%>
    <%--/*删除后回到本页*/--%>
    <%--to_page(currentPage);--%>
    <%--}--%>
    <%--});--%>
    <%--$(".my-alert > div > h2").text("删除成功!");--%>
    <%--$(".my-alert").show(1000, function () {--%>
    <%--$(".my-alert").hide(2000);--%>
    <%--});--%>
    <%--}--%>
    <%--});--%>

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
