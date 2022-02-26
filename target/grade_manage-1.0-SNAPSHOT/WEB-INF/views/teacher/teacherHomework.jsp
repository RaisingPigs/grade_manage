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


<%--学生增加的模态框--%>
<div class="modal fade" id="stuAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title text-center" id="myModalLabel" data-toggle="tooltip" data-placement="bottom"
                    title="成绩占比总和必须为100!">作业题目发布</h4>
            </div>
            <div class="modal-body">

                <%--模态框的内嵌表单--%>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="stuName_add_input" class="col-sm-2 control-label">作业</label>
                        <div class="col-sm-10" id="stuName_add_div">
                            <input type="text" class="form-control " name="question" id="stuName_add_input"
                                   autocomplete="off"
                                   placeholder="输入作业题目">
                        </div>
                    </div>
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
                <li>
                    <a href="${APP_PATH}/teacherStudentInfoControl/${tId}"><span
                            class="glyphicon glyphicon-user"></span>
                        学生管理</a>
                </li>
                <li>
                    <a href="${APP_PATH}/teacherPersonalInfoControl/${tId}"><span class="glyphicon glyphicon-list-alt"></span>
                        个人信息</a>
                </li>
                <li  class="active">
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
                <div class="col-md-3 pull-right">
                    <button class="btn btn-primary center-block" id="stu_add_modal_btn">发布作业</button>
                </div>
            </div>

            <div class="common">
                <ul>
                    <c:forEach items="${distinctHomework}" var="item">
                        <li class="listbox mr20">
                            <div class="listimg">
                                <a href="${APP_PATH}/teacherStudentHomeworkControl/${tId}/${item.hwkId}">
                                    <c:if test="${teacher.cName eq 'java'}">
                                        <img src="${APP_PATH}/static/img/java.gif" class="time-img">
                                    </c:if>
                                    <c:if test="${teacher.cName eq 'c'}">
                                        <img src="${APP_PATH}/static/img/c.png" class="time-img">
                                    </c:if>
                                    <c:if test="${teacher.cName eq 'cpp'}">
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
                                <div class="list-tag"><span class="iconfont icon-fangzi"></span><a href="#">发布老师: ${teacher.tchName}</a><a href="#">课程: ${teacher.cName}</a></div>
                                <div class="list-date"><span class="iconfont icon-shijian_zhongbiao"></span>2020-12-26
                                </div>
                                <div class="list-view"><span class="iconfont icon-yanjing"></span>6253</div>
                                <div class="list-comment"><span class="iconfont icon-pinglun"></span>16</div>
                                <div class="list-demo delete_expr" id="${item.hwkId}"><a href="#">删除</a></div>
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

<script>
    var totalRecord, currentPage;
    var stuName = "";

    $(function () {
      
    });

    /*点击新增按钮弹出模态框*/
    $("#stu_add_modal_btn").click(function () {
        /*弹出模态框*/
        $("#stuAddModal").modal({
            backdrop: "static" /*点击背景模态框不消失*/
        });
    });

    
    /*发布作业模态框中的保存按钮的单击事件*/
    $("#stu_save_btn").click(function () {
        /*将模态框中填写的表单数据提交给服务器进行保存*/
        $.ajax({
            url: "${APP_PATH}/insertHwk/${tId}",
            data: $("#stuAddModal form").serialize(),
            type: "put",
            success: function (result) {
                if (result.code === 100) {
                    /*保存成功后, 关闭模态框*/
                    $("#stuAddModal").modal("hide");
                    
                    $(".my-alert > div > h2").text("发布成功!");
                    $(".my-alert").show(1000, function () {
                        $(".my-alert").hide(2000);
                    });

                    setTimeout(function () {
                        location.reload(true);
                    }, 2000);
                }
              
            },
            dataType: "json"
        });
    });

    $(".delete_expr").click(function () {
        if (confirm("你确定要删除吗?")) {
            $.ajax({
                url: "${APP_PATH}/deleteHwk/" + $(this).attr("id"),
                type: "delete",
                success: function (result) {
                    if (result.code === 100) {
                        $(".my-alert > div > h2").text("删除成功!");
                        $(".my-alert").show(1000, function () {
                            $(".my-alert").hide(2000);
                        });

                        setTimeout(function () {
                            location.reload(true);
                        }, 2000);
                    }
                }
            });
        }
    });
</script>

</body>
</html>
