<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8"/>
    <%--<meta HTTP-EQUIV="REFRESH" CONTENT="60"/>--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <title>Login</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/css/todc-bootstrap.min.css" rel="stylesheet"/>
    <link href="resources/css/custom/signin.css" rel="stylesheet"/>

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet"/>

    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="resources/css/ie8-responsive-file-warning.js"></script>
    <![endif]-->
    <script src="resources/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="card-signin">
    <img class="img-circle profile-img" src="resources/img/avatar.png" alt=""/>

    <form class="form-horizontal" action="/login" method="post">
        <c:if test="${param.error}">
            <div style="text-align: center; color: red">
                用户名或者密码错误
            </div>
        </c:if>
        <div class="form-group">
            <label for="username" class="col-sm-3 control-label">用户名</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="username" name="username" placeholder="用户名"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-3 control-label">密码</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" id="password" name="password" placeholder="密码"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remember-me"/> 保持登录
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <button type="submit" class="btn btn-default btn-lg btn-block">登 录</button>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>