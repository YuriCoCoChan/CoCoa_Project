<%--
  Created by IntelliJ IDEA.
  User: CoCo
  Date: 2021/1/7
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录 | 页面</title>
</head>
<script type="text/javascript" src="js/poppers-2.6.0.js"></script>
<script type="text/javascript" src="js/jquery3.5.1-min.js"></script>
<script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/icons-1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/login.css">

<body>
<header>
    <div class="font-weight-bold col-xl-6 container navbar-expand-md thead-light" id="nav-login">
        <nav class="navbar navbar-light">
            <a href="javascript:void(0)" class="navbar-brand">CoCo</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#menu">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="menu" class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item"><a href="mainindex" class="my-nav-link">首页</a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="my-nav-link">Blog</a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="my-nav-link">Shop</a></li>
                </ul>
            </div>
        </nav>
    </div>
</header>
<main>
    <section id="workFrm">
        <!--    登录-->
        <div class="container">

            <div class="mt-5" style="z-index: 99999;position: absolute">
                <ul class="nav nav-tabs" style="display: block;width: 50px;" id="nav_item_log_reg">
                    <li class="nav-item" id="nav-log-link"><a href="#loginStatus" class="my-nav-link_lr "
                                                              data-toggle="tab">登录</a></li>
                    <li class="nav-item" id="nav-reg-link"><a href="#registerStatus" class="my-nav-link_lr"
                                                              data-toggle="tab">注册</a></li>
                </ul>
            </div>

            <div class="tab-content">
                <div class="frm frmLogin active tab-pane" id="loginStatus">
                    <form action="404" method="post" id="loginForm">
                        <table class="text-center">
                            <thead>
                            <tr>
                                <th colspan="2"><h2 class="display-4 text-white" id="loginTitle">Admin Mode</h2></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="loginFrmFont">
                                <td><i class="bi bi-person"></i></td>
                                <td><input type="text" placeholder="请输入账户/Please input username" name="usernameLogin"
                                           autocomplete="off" maxlength="22" minlength="4"
                                           value="${requestScope.username}"></td>
                            </tr>
                            <tr class="loginFrmFont">
                                <td><i class="bi bi-lock"></i></td>
                                <td><input type="password" placeholder="请输入密码/Please input password" name="pswLogin"
                                           autocomplete="off" maxlength="40" minlength="6"
                                           value="${requestScope.password}"></td>
                            </tr>
                            <tr class="loginFrmFont">
                                <td colspan="2">
                                    <span>可视密码 : </span>
                                    <input type="checkbox" id="seePsw">
                                    <span>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;保存密码 :</span>
                                    <input type="checkbox" name="savePsw" value="1">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="button" value="登录" class="submitBtn mt-4 ml-4"
                                                       id="submitLogin">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>

                <!--    注册-->
                <div class="frm frmReg tab-pane" id="registerStatus">
                    <!--                 id="form"-->
                    <form action="404" method="post" id="formReg">
                        <table class="text-center">
                            <thead>
                            <tr>
                                <th colspan="2"><h2 class="display-4 text-white">Register Mode</h2></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr class="loginFrmFont">
                                <td>账 | 户 :</td>
                                <td><input type="text" placeholder="请输入账户 | Please Input Username" name="usernameReg"
                                           autocomplete="off" maxlength="22" minlength="4"></td>
                            </tr>
                            <tr class="loginFrmFont">
                                <td>密 | 码:</td>
                                <td><input type="password" placeholder="请输入密码 | Please Input Password" name="pswReg"
                                           autocomplete="off" maxlength="40" minlength="6"></td>
                            </tr>

                            <tr class="loginFrmFont">
                                <td>确认|密码:</td>
                                <td><input type="password" placeholder="请确认密码 | Please Confirm Password"
                                           name="pswRegConfirm"
                                           autocomplete="off" maxlength="40" minlength="6"></td>
                            </tr>
                            <tr class="loginFrmFont">
                                <td>手机 | 邮箱:</td>
                                <td><input type="email" placeholder="输入邮箱或电话 | Input Email Or Tele" name="emailOrTel"
                                           autocomplete="off" maxlength="40" minlength="6"></td>
                            </tr>

                            <tr>

                                <td colspan="2" class="pl-5">
                                    <input type="button" value="注册" class="submitBtn mt-4 ml-4" id="submitRegister">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <!--    欢迎登陆-->
    <section id="frmWelcome" style="display: none">
        <div class="frm active text-center p-5 text-light">
            <div class="m-auto" id="frmWelcomeTitle">
                <img src="" alt="" class="w-100 h-100" style="border-radius: 50%">
            </div>
            <div class="mt-2">
                <h4>欢迎回来</h4>
                <h4 id="welcomeName"></h4>
                <h5><span id="second"></span><span class="spinner-border text-light" role="status"></span></h5>
            </div>
        </div>
    </section>
</main>
<footer class="text-center py-4 " style="color: white;position: absolute;bottom: 0;left: 0;right: 0">
    <div>
        <p>@CopyRight_CoCo</p>
    </div>
</footer>
</body>
</html>