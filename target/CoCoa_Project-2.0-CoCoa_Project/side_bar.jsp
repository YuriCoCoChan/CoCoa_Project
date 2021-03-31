<%--
  Created by IntelliJ IDEA.
  User: CoCo
  Date: 2021/3/1
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<html lang="zh">
<head>
    <title>Bootstrap 实例</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/icons-1.3.0/font/bootstrap-icons.css">
    <script type="text/javascript" src="js/jquery3.5.1-min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
</head>

<link rel="stylesheet" href="css/side_bar.css">
<script type="text/javascript" src="js/side_bar.js"></script>
<body style="background-color: #353b48">
<div id="accordion">
    <!--选项-->
    <ul>
        <%--        --%>
        <li class="myCard">
            <div class="">
                <p class="" data-toggle="collapse" href="#collapseOne">
                    网站检视
                </p>
            </div>

            <!--里-->
            <ul id="collapseOne" class="collapse hide" data-parent="#accordion" name="insideBar">
                <li class="card-body">
                    <a href="${pageContext.request.contextPath}/mainindex" target="work">首页</a>
                </li>
                <li class="card-body">
                    <a href="${pageContext.request.contextPath}/tologin" target="work">登录与注册</a>
                </li>
                <li class="card-body">
                    <a href="bootstrapLearn.jsp" target="work">BootStrap-Learn</a>
                </li>
            </ul>
        </li>
        <%--        --%>
        <li class="myCard">
            <div class="">
                <p class="" data-toggle="collapse" href="#collapseTwo">
                    业务管理
                </p>
            </div>

            <!--里-->
            <ul id="collapseTwo" class="collapse hide" data-parent="#accordion" name="insideBar">
                <li class="card-body">
                    <a href="${pageContext.request.contextPath}/user_system" target="work">管理账户</a>
                </li>
                <li class="card-body">
                    <a href="${pageContext.request.contextPath}/backmain" target="work">网站数据</a>
                </li>
            </ul>
        </li>
    </ul>

</div>

</body>
</html>
