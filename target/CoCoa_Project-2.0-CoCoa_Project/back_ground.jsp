<%--
  Created by IntelliJ IDEA.
  User: CoCo
  Date: 2021/3/1
  Time: 2:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后 台</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/icons-1.3.0/font/bootstrap-icons.css">
    <script type="text/javascript" src="js/jquery3.5.1-min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
</head>
<link rel="stylesheet" href="css/back_end.css">
<script type="text/javascript" src="js/back_end.js"></script>
<body style="background-color: #353b48">
<main>
    <section class=" m-0 p-0">
        <div class="row p-0 m-0">
            <div class="d-none d-lg-block col-lg-1 m-0 p-0 ">
                <!--                导航-->
                <iframe src="side_bar.jsp" frameborder="0" style="background-color: #353b48;"
                        onscroll="true"
                        id="sideBar"></iframe>
            </div>
            <!--            显示-->
            <div class="col-lg-11 m-0 p-0" id="work">
                <iframe frameborder="0" name="work" class="col-12 m-0 p-0"
                        src="background_main_index.jsp" height="100%"></iframe>
            </div>
        </div>
    </section>
</main>
</body>
</html>