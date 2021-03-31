<%--
  Created by IntelliJ IDEA.
  User: CoCo
  Date: 2021/1/8
  Time: 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <script type="text/javascript" src="js/jquery3.5.1-min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <style type="text/css">
        .myheader {
            background: url("image/resource/login_bg.jpg");
        }
    </style>
</head>
<body>
<header>
    <!--    提示框-->
    <div class="alert alert-dark text-light text-center mb-0 alert-dismissible fade show">
        提示框测试
        <button class="close" data-dismiss="alert">&times;</button>
    </div>

    <!--    导航栏-->
    <div class="container">
        <nav class="navbar navbar-expand-sm navbar-light">
            <a href="javascript:void(0)" class="navbar-brand">CoCo | Bootstrap 艰难的学习</a>
            <button class="navbar-toggler" data-toggle="collapse" data-target="#menu">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div id="menu" class="collapse navbar-collapse">
                <ul class="navbar-nav">
                    <li class="nav-item"><a href="javascript:void(0)" class="nav-link">Youtube</a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="nav-link">AcFun.cn</a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="nav-link">BiliBili</a></li>
                </ul>
            </div>
        </nav>
    </div>


    <div class="myheader text-danger text-center py-5">
        <h1 class="display-4 text-danger">CoCo | BootStrap的艰难学习过程中</h1>
        <div class="mt-4">
            <a href="javascript:void(0)" class="btn btn-danger mr-2">Youtube</a>
            <a href="javascript:void(0)" class="btn btn-info">BiliBili</a>
        </div>
    </div>
</header>

<main>
    <section class="py-5">
        <h2 class="text-center mb-5">BootStrap的艰难学习</h2>
        <div class="container">
            <div class="mb-5 row">
                <div class="col-md-9">
                    <h3>BootStrap的艰难学习</h3>
                    <p>Bootstrap是美国Twitter公司的设计师Mark Otto和Jacob Thornton合作基于HTML、CSS、JavaScript 开发的简洁、直观、强悍的前端开发框架，使得
                        Web
                        开发更加快捷。Bootstrap提供了优雅的HTML和CSS规范，它即是由动态CSS语言Less写成。Bootstrap一经推出后颇受欢迎，一直是GitHub上的热门开源项目，包括NASA的MSNBC（微软全国广播公司）的Breaking
                        News都使用了该项目。 [1] 国内一些移动开发者较为熟悉的框架，如WeX5前端开源框架等，也是基于Bootstrap源码进行性能优化而来</p>
                </div>
                <div class="col-md-3">
                    <img src="image/avatar/default.jpg" class="w-100" alt="">
                </div>
            </div>

            <div class="mb-5 row">
                <div class="col-md-9 order-md-2">
                    <h3>BootStrap的艰难学习</h3>
                    <p>Bootstrap是美国Twitter公司的设计师Mark Otto和Jacob Thornton合作基于HTML、CSS、JavaScript 开发的简洁、直观、强悍的前端开发框架，使得
                        Web
                        开发更加快捷。Bootstrap提供了优雅的HTML和CSS规范，它即是由动态CSS语言Less写成。Bootstrap一经推出后颇受欢迎，一直是GitHub上的热门开源项目，包括NASA的MSNBC（微软全国广播公司）的Breaking
                        News都使用了该项目。 [1] 国内一些移动开发者较为熟悉的框架，如WeX5前端开源框架等，也是基于Bootstrap源码进行性能优化而来</p>
                </div>
                <div class="col-md-3 order-md-1">
                    <img src="image/avatar/default.jpg" class="w-100" alt="">
                </div>
            </div>

            <div class="mb-5 row">
                <div class="col-md-9">
                    <h3>BootStrap的艰难学习</h3>
                    <p>Bootstrap是美国Twitter公司的设计师Mark Otto和Jacob Thornton合作基于HTML、CSS、JavaScript 开发的简洁、直观、强悍的前端开发框架，使得
                        Web
                        开发更加快捷。Bootstrap提供了优雅的HTML和CSS规范，它即是由动态CSS语言Less写成。Bootstrap一经推出后颇受欢迎，一直是GitHub上的热门开源项目，包括NASA的MSNBC（微软全国广播公司）的Breaking
                        News都使用了该项目。 [1] 国内一些移动开发者较为熟悉的框架，如WeX5前端开源框架等，也是基于Bootstrap源码进行性能优化而来</p>
                </div>
                <div class="col-md-3">
                    <img src="image/avatar/default.jpg" class="w-100" alt="">
                </div>
            </div>

        </div>
    </section>

    <section class="bg-light text-center py-5">
        <h2>今后计划</h2>
        <div class="container">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="text-center">前台</th>
                    <th class="text-center">后台管理</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>BootStrap</td>
                    <td>Servlet</td>
                </tr>
                <tr>
                    <td>jQuery</td>
                    <td>Filter</td>
                </tr>
                </tbody>
            </table>
        </div>
    </section>

    <section class="py-5">
        <h2 class="text-center"></h2>
        <div class="container">
            <ul class="nav nav-tabs">
                <li class="nav-item"><a href="#java" class="nav-link active" data-toggle="tab">Java</a></li>
                <li class="nav-item"><a href="#c" class="nav-link" data-toggle="tab">C语言</a></li>
            </ul>
            <!--显示内容-->
            <div class="tab-content py-3">
                <div id="java" class="tab-pane active">
                    <p>Java从入门到<span class="text-success" title="显示的文字" data-toggle="tooltip"
                                     data-placement="top">精通 </span></p>
                </div>
                <div id="c" class="tab-pane">
                    <p>C 从入门到放弃\入坟</p>
                </div>
            </div>
        </div>
    </section>

    <section class="bg-light text-center py-4">
        <a href="javascript:void(0)" class="btn btn-danger">Youtube</a>
        <a href="javascript:void(0)" class="btn btn-info">BiliBili</a>
    </section>
</main>

<footer class="text-center text-muted py-4">
    <p>@CoCo</p>
</footer>
</body>
</html>
<!--
nav 导航
nav-tabs 设置区域 是导航
nav-item 导航项
nav-link 以这个样式的形式 展示
tab-content ||nav-item 具体要的 内容区
tab-pane 主题显示
data-toggle="tab" 交互方式 [bootstrap写好的组件]
active 默认
-->

<!--
data-toggle 目标
data-placement 放置位置
-->

<!--
navbar 导航条
nav-expend- 什么大小显示
-->

<!--
alert
alert-* 颜色

关于关掉 提示的写法
close
data-dismiss="alert"
-->
<script type="text/javascript">
    $(function () {
        $('[data-toggle = "tooltip"]').tooltip();
    })

</script>