<%--
  Created by IntelliJ IDEA.
  User: CoCo
  Date: 2021/3/9
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台主页面</title>
    <script type="text/javascript" src="js/jquery3.5.1-min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/icons-1.3.0/font/bootstrap-icons.css">
</head>
<body style="background-color: #353b48">
<main>
    <section class="container-fluid">
        <div class="row">

            <div name="outside-dialog" class="p-3 col-md-6 col-lg-3 overflow-hidden">
                <div name="dialog-background" class="w-100 row m-0 p-0" style="background:#EE5A24;">
                    <div name="icon" class="col-5 m-auto text-center">
                        <i class="bi bi-person-circle" style="font-size: 3.5rem"></i>
                    </div>
                    <div name="info" class="bg-white col-7 p-1 text-center pt-3">
                        <h3>${applicationScope.countOnline}</h3>
                        <h5>在 线 人 数</h5>
                    </div>
                </div>
            </div>

            <div name="outside-dialog" class="p-3 col-md-6 col-lg-3 overflow-hidden">
                <div name="dialog-background" class="w-100 row m-0 p-0" style="background-color: #ff793f">
                    <div name="icon" class="col-5 m-auto text-center">
                        <i class="bi bi-people" style="font-size: 3.5rem"></i>
                    </div>
                    <div name="info" class="bg-white col-7 p-1 text-center pt-3">
                        <h3>${applicationScope.countViewsUser}</h3>
                        <h5>总访问人数</h5>
                    </div>
                </div>
            </div>

            <div name="outside-dialog" class="p-3 col-md-6 col-lg-3 overflow-hidden">
                <div name="dialog-background" class="w-100 row m-0 p-0" style="background-color: #ff7675">
                    <div name="icon" class="col-5 m-auto text-center">
                        <i class="bi bi-emoji-smile" style="font-size: 3.5rem"></i>
                    </div>
                    <div name="info" class="bg-white col-7 p-1 text-center pt-3">
                        <h3>%.%</h3>
                        <h5>No Info</h5>
                    </div>
                </div>
            </div>

            <div name="outside-dialog" class="p-3 col-md-6 col-lg-3 overflow-hidden">
                <div name="dialog-background" class="w-100 row m-0 p-0" style="background-color: #e15f41">
                    <div name="icon" class="col-5 m-auto text-center">
                        <i class="bi bi-emoji-frown" style="font-size: 3.5rem"></i>
                    </div>
                    <div name="info" class="bg-white col-7 p-1 text-center pt-3">
                        <h3>%.%</h3>
                        <h5>No Info</h5>
                    </div>
                </div>
            </div>

        </div>
    </section>
</main>
</body>
</html>
