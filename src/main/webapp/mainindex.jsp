<%--
  Created by IntelliJ IDEA.
  User: CoCo
  Date: 2021/1/10
  Time: 8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CoCo | MainIndex</title>
</head>
<script type="text/javascript" src="js/jquery3.5.1-min.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/mainIndex.js"></script>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/icons-1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/mainIndex.css">
<body data-spy="scroll" data-target="#scrollNav" data-offset="1">
<header id="top">
    <!--    导航栏-->
    <section>
        <div class="container p-3">
            <nav class="navbar navbar-expand-md navbar-light">
                <a href="javascript:void (0)" class="navbar-brand">CoCo | MainIndex</a>
                <button class="navbar-toggler" data-toggle="collapse" data-target="#menu,#login,#cart,#more">
                    <i class="navbar-toggler-icon"></i>
                </button>
                <div class="collapse navbar-collapse justify-content-center" id="menu">
                    <ul class="navbar-nav">
                        <li class="nav-item"><a href="javascript:void (0)" class="nav-link">首页</a></li>
                        <li class="nav-item"><a href="javascript:void (0)" class="nav-link">Blog</a></li>
                        <li class="nav-item"><a href="javascript:void (0)" class="nav-link">Shop</a></li>
                    </ul>
                </div>

                <!--            图标-->
                <div class="justify-content-end order-9 " id="icons">
                    <ul class="navbar-nav ml-0" style="text-align: center">
                        <li class="nav-item">
                            <%--                        未登录的状态--%>
                            <a href="${pageContext.request.contextPath}/tologin" class="nav-link" id="loginHref">
                                <i class="bi bi-person-bounding-box"></i>
                                <span class="collapse" id="login">登录 Login</span>
                            </a>
                            <%--                        已登录后的状态--%>
                            <%--                            头像--%>
                            <%--                            头像--%>
                            <div class="rounded-circle position-relative" id="userTitle">
                                <%--                            下拉框--%>
                                <div style="display: none;width: 200px;" id="downlist" class="dropdown-menu">
                                    <button type="reset" class="list-group-item list-group-item-action btn btn-info"
                                            data-toggle="modal"
                                            data-target="#changeProfile" value="更改个人资料">更改个人资料
                                    </button>

                                    <button type="button" class="list-group-item list-group-item-action btn btn-info"
                                            data-toggle="modal" data-target="#changeTitleModal">更改个人头像
                                    </button>

                                    <button type="button" class="list-group-item list-group-item-action btn btn-info"
                                            id="loginOut">
                                        退出登录
                                    </button>
                                </div>

                            </div>
                        </li>

                        <%--                    购物车--%>
                        <li class="nav-item p-0">
                            <a href="javascript:void (0)" class="nav-link">
                                <i class="bi bi-cart"></i>
                                <span class="collapse" id="cart">购物车 Cart</span>
                            </a>
                        </li>

                        <%--                    更多--%>
                        <li class="nav-item"><a href="javascript:void (0)" class="nav-link">
                            <i class="bi bi-command"></i>
                            <span class="collapse" id="more">更多&nbsp;&nbsp;&nbsp;&nbsp;More</span>
                        </a>
                        </li>
                    </ul>
                </div>

            </nav>
        </div>
    </section>

    <%--                                个人资料模态框--%>
    <section>
        <div>
            <div class="modal fade text-left" id="changeProfile" tabindex="-1" role="dialog"
                 aria-labelledby="changeProfileModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="changeProfileModalLabel">更改个人资料</h5>
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">
                            <form action="javascript:void(0)" method="get" id="profile">
                                <!--                所属用户组[不可更改]-->
                                <div class="form-group disabled">
                                    <label for="group">用户组 [不可更改]</label>
                                    <input type="text" class="form-control" id="group"
                                           aria-describedby="emailHelp" name='userGroup'
                                           readonly>
                                </div>

                                <!--                账户名[不可更改]-->
                                <div class="form-group disabled">
                                    <label for="username">账户名 [不可更改]</label>
                                    <input type="text" class="form-control" id="username"
                                           aria-describedby="emailHelp" name="username"
                                           readonly>
                                </div>

                                <!--                邮箱[不可更改]-->
                                <div class="form-group disabled">
                                    <label for="inputEmail1">邮箱地址</label>
                                    <input type="email" class="form-control" id="inputEmail1"
                                           aria-describedby="emailHelp"
                                           name="email">
                                    <small id="emailHelp" class="form-text text-muted">We'll never
                                        share your email with
                                        anyone
                                        else.</small>
                                    <small class="invalid-feedback">
                                        邮箱格式不正确
                                    </small>
                                </div>

                                <!--                电话[暂时不可更改]-->
                                <div class="form-group disabled">
                                    <label for="inputMobile">电话号码</label>
                                    <input type="text" class="form-control" id="inputMobile"
                                           aria-describedby="emailHelp"
                                           name="mobile">
                                    <small id="mobileHelp" class="form-text text-muted">We'll never
                                        share your tele with
                                        anyone
                                        else.</small>
                                    <small class="invalid-feedback">
                                        电话格式不正确
                                    </small>
                                </div>

                                <!--                出生地址-->
                                <div class="mb-3">
                                    <h4>出生地址</h4>
                                </div>
                                <div class="form-row">
                                    <div class="form-group ml-3">
                                        <label for="inputProvincial">省</label>
                                        <select id="inputProvincial" class="form-control" required
                                                name="userProvincial">
                                            <option selected value="0">请选择...</option>
                                            <c:forEach items="${requestScope.provincial}" var="provincialName">
                                                <option value="${provincialName.provincialId}">${provincialName.provincialName}</option>
                                            </c:forEach>
                                        </select>
                                        <div class="invalid-feedback">
                                            请选择省区
                                        </div>
                                    </div>

                                    <div class="form-group ml-5">
                                        <label for="inputState">市</label>
                                        <select id="inputState" class="form-control" required name="userCity">
                                            <option selected value="0">请选择...</option>
                                        </select>
                                        <div class="invalid-feedback">
                                            请选择市区
                                        </div>
                                    </div>
                                </div>

                                <!--                出生日期-->
                                <div class="mb-3">
                                    <h4>出生日期</h4>
                                </div>
                                <div class="form-group disabled col-5 m-0 p-0">
                                    <input type="date" class="form-control text-center" id="date" name="userBirth"
                                           aria-describedby="emailHelp"
                                           style="width: 357px">
                                </div>

                                <!--                年龄-->
                                <div class="form-group disabled w-50">
                                    <label for="group">年龄</label>
                                    <input type="text" class="form-control text-center" id="age" name="age"
                                           aria-describedby="emailHelp"
                                           readonly placeholder="请直接选择出生日期">
                                </div>

                                <!--                性别-->
                                <div class="mb-3 mt-3">
                                    <h4>性别</h4>
                                </div>
                                <div class="form-check form-check-inline form-group">
                                    <input class="form-check-input" type="radio"
                                           name="sexRadios" id="maleSex"
                                           value="1" checked>
                                    <label class="form-check-label" for="maleSex">
                                        男
                                    </label>
                                </div>
                                <div class="form-check form-check-inline form-group">
                                    <input class="form-check-input" type="radio"
                                           name="sexRadios" id="femaleSex"
                                           value="0">
                                    <label class="form-check-label" for="femaleSex">
                                        女
                                    </label>
                                </div>
                                <div class="form-check form-check-inline form-group">
                                    <input class="form-check-input" type="radio"
                                           name="sexRadios" id="elseSex"
                                           value="2">
                                    <label class="form-check-label" for="elseSex">
                                        其它
                                    </label>
                                </div>

                                <!--                提交按钮-->
                                <br>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary"
                                            data-dismiss="modal">Close
                                    </button>
                                    <button type="submit" class="btn btn-primary" id="submitChangeProfile">Save changes
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>

    <%--头像模态框--%>
    <div class="modal fade overflow-hidden" id="changeTitleModal" tabindex="-1" role="dialog"
         aria-labelledby="changeTitle"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content bg-dark text-light">
                <div class="modal-header">
                    <h5 class="modal-title" id="changeTitle">更改个人头像  <span class="small">*.上传成功后头像需审核等待</span></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="modal-body text-center bg-dark">
                    <form action="${pageContext.request.contextPath}/avatar" method="post" enctype="multipart/form-data"
                          id="titleFrm">
                        <div class="rounded-circle m-auto" id="titleShowFrm">

                        </div>
                        <div class="mt-3 mb-3">
                            <input type="file" id="pictureFile" name="pictureFile" class="btn btn-dark overflow-hidden" accept="image/*">
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal" id="titleUploadClose">
                                Close
                            </button>
                            <input type="submit" class="btn btn-primary" id="changeTitleBtn" value="Save changes">
                        </div>
                    </form>

                </div>


            </div>

        </div>
    </div>

    <!--    轮播图-->
    <section>
        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel" data-interval="2000"
             data-pause="false">
            <%--           下面的框         --%>
            <ol class="carousel-indicators">
                <c:forEach items="${requestScope.recommendGoods}" varStatus="index">
                    <c:choose>
                        <c:when test="${index.index==0}">
                            <li data-target="#carouselExampleCaptions" data-slide-to="${index.index}"
                                class="active bg-dark"></li>
                        </c:when>
                        <c:otherwise>
                            <li data-target="#carouselExampleCaptions" class="bg-dark"
                                data-slide-to="${index.index}"></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </ol>

            <%--           图片         --%>
            <div id="carouselExampleInterval" class="carousel slide">
                <div class="carousel-inner">
                    <c:forEach items="${requestScope.recommendGoods}" var="goods" varStatus="index">
                        <c:choose>
                            <c:when test="${index.index==0}">
                                <div class="carousel-item active">
                                    <img src="${pageContext.request.contextPath}${goods.goodImgSrc}"
                                         class="d-block w-100 h-100"
                                         alt="...">
                                    <div class="carousel-caption">
                                        <h5>${goods.goodName}</h5>
                                        <p>${goods.goodPrice}</p>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="carousel-item">
                                    <img src="${pageContext.request.contextPath}${goods.goodImgSrc}"
                                         class="d-block w-100 h-100"
                                         alt="...">
                                    <div class="carousel-caption">
                                        <h5>${goods.goodName}</h5>
                                        <p>${goods.goodPrice}</p>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
            </div>

            <%--           左右箭头         --%>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </section>
</header>
<main class="mt-5">
    <%--  滚轮监视 --%>
    <section class="d-none d-xl-block">
        <nav id="scrollNav" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top justify-content-center"
             style="display: none;line-height: 50px">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="#top">置顶轮播图 <i class="bi bi-arrow-up-circle"></i></a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#newGood">新商品</a>
                </li>
                <c:if test="${requestScope.artGoods!=null}">
                    <li class="nav-item">
                        <a class="nav-link" href="#artGood">展览??[实在不知道给什么名字]</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <a class="nav-link" href="#popularGood">热门商品</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#footer">底部 <i class="bi bi-arrow-down-circle"></i></a>
                </li>
            </ul>
        </nav>
    </section>

    <!--    新商品-->
    <section id="newGood">
        <div class="container">
            <h2 class="display-4">New Arrivals</h2>

            <div class="row newGoods">
                <c:forEach items="${requestScope.newGoods}" var="good" varStatus="i">
                    <div class="col-lg-4 col-md-6 p-3 goodsBox">
                        <div class="w-100 h-75" name="newGoodImg">
                            <img src="${pageContext.request.contextPath}${good.goodImgSrc}" alt="">
                        </div>
                        <div class="w-100 h-25 text-center p-4">
                            <h3>${good.goodName}</h3>
                            <h4>$ ${good.goodPrice}</h4>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>

    <!--    展示商品-->
    <section id="artGood">
        <c:forEach items="${requestScope.artGoods}" var="good" varStatus="i">
            <c:choose>
                <c:when test="${i.index%2==0}">
                    <div class="mt-3" name="old">
                        <div class="container">
                            <div class="row">
                                <div class="col-xl-4" name="fontContent">
                                    <p>${good.goodDescription}</p>
                                </div>
                                <div class="col-xl-8" name="imgContent">
                                    <img src="${pageContext.request.contextPath}${good.goodImgSrc}" alt="" class="w-100"
                                         style="width: 100%;height: auto">
                                </div>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:when test="${i.index%2!=0}">
                    <div name="old" class="mt-3">
                        <div class="container">
                            <div class="row">
                                <div class="col-xl-4 order-md-10 p-3" name="fontContent">
                                    <p>${good.goodDescription}</p>
                                </div>
                                <div class="col-xl-8  order-md-0" name="imgContent">
                                    <img src="${pageContext.request.contextPath}${good.goodImgSrc}" alt=""
                                         class="w-100">
                                </div>
                            </div>
                        </div>
                    </div>
                </c:when>
            </c:choose>
        </c:forEach>
    </section>
    <!--    热门商品-->
    <section class="mt-5" id="popularGood">
        <div class="container text-center">
            <h2 class="display-4">Popular Arrivals</h2>

            <div class="row newGoods">
                <c:forEach items="${requestScope.popularGoods}" var="good">
                    <div class="col-lg-4 col-md-6 p-3 goodsBox">
                        <div class="w-100 h-75" name="newGoodImg">
                            <img src="${pageContext.request.contextPath}${good.goodImgSrc}" alt="">
                        </div>
                        <div class="w-100 h-25 text-center p-4">
                            <h3>${good.goodName}</h3>
                            <h4>$ ${good.goodPrice}</h4>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </section>

    <section class="mt-5 mb-5">
        <div class="container">
            <!--            <div class="text-center">
                            <h4>
                                <span>常逛的网站</span> | <span>使用的工具</span> | <span>本站使用到的框架</span>
                            </h4>
                        </div>-->
            <div class="row ml-0 mr-0 text-center">
                <div class="col-md-4 col-sm-12">
                    <h4 class="btn btn-dark">常逛的网站 <span class="badge badge-dark">10</span></h4>
                </div>
                <div class="col-md-4 col-sm-12">
                    <h4 class="btn btn-info">使用的工具 <span class="badge badge-danger">4</span></h4>
                </div>
                <div class="col-md-4 col-sm-12">
                    <h4 class="btn btn-primary">本站使用到的框架 <span class="badge badge-light">2</span></h4>
                </div>
            </div>
            <%--<div class="overflow-hidden mt-5">
                <ul class="p-0" id="sportIcons" style="width: 1000%">
                    <li><img src="" alt=""></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                </ul>
            </div>
        </div>--%>
    </section>
</main>

<footer id="footer">
    <div class="container-fluid bg-secondary align-content-center font-weight-bold text-center text-dark p-4"
         style="">
        <p>@CopyCoCo</p>
    </div>
    <div class="spinner-bo" role="status">
        <span class="sr-only">Loading...</span>
    </div>
</footer>
</body>
</html>
