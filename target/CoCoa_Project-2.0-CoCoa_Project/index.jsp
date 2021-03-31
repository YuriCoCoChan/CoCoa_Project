<%--
  Created by IntelliJ IDEA.
  User: CoCo
  Date: 2021/1/7
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <script type="text/javascript" src="js/jquery3.5.1-min.js"></script>
  <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/icons-1.3.0/font/bootstrap-icons.css">
  <body>
  <main>
    <section>
      <!-- Button trigger modal -->
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#changeProfile">
        更改个人资料
      </button>

      <!-- Modal -->
      <div class="modal fade " id="changeProfile" tabindex="-1" role="dialog"
           aria-labelledby="changeProfileModalLabel"
           aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">

          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="changeProfileModalLabel">更改个人资料</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>

            <div class="modal-body">
              <form action="404" method="get">
                <!--                所属用户组[不可更改]-->
                <div class="form-group disabled">
                  <label for="group">用户组 [不可更改]</label>
                  <input type="text" class="form-control" id="group" aria-describedby="emailHelp"
                         readonly>
                </div>

                <!--                账户名[不可更改]-->
                <div class="form-group disabled">
                  <label for="username">账户名 [不可更改]</label>
                  <input type="text" class="form-control" id="username" aria-describedby="emailHelp"
                         readonly>
                </div>

                <!--                邮箱[不可更改]-->
                <div class="form-group disabled">
                  <label for="inputEmail1">邮箱地址 [暂时不可更改]</label>
                  <input type="email" class="form-control" id="inputEmail1" aria-describedby="emailHelp"
                         readonly>
                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with
                    anyone
                    else.</small>
                </div>

                <!--                电话[暂时不可更改]-->
                <div class="form-group disabled">
                  <label for="inputMobile">电话号码 [暂时不可更改]</label>
                  <input type="text" class="form-control" id="inputMobile" aria-describedby="emailHelp"
                         readonly>
                  <small id="MobileHelp" class="form-text text-muted">We'll never share your tele with
                    anyone
                    else.</small>
                </div>

                <!--                出生地址-->
                <div class="mb-3">
                  <h4>出生地址</h4>
                </div>
                <div class="form-row">
                  <div class="form-group ml-3">
                    <label for="inputProvincial">省</label>
                    <select id="inputProvincial" class="form-control" required>
                      <option selected>Choose...</option>
                      <option>...</option>
                    </select>
                    <div class="invalid-feedback">
                      请选择省区
                    </div>
                  </div>

                  <div class="form-group ml-5">
                    <label for="inputState">市</label>
                    <select id="inputState" class="form-control" required>
                      <option selected>Choose...</option>
                      <option>...</option>
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
                  <input type="date" class="form-control text-center" id="date"
                         aria-describedby="emailHelp"
                         style="width: 357px" required>
                </div>

                <!--                年龄-->
                <div class="form-group disabled w-50">
                  <label for="group">年龄</label>
                  <input type="text" class="form-control text-center" id="age"
                         aria-describedby="emailHelp"
                         readonly placeholder="请直接选择出生日期">
                </div>

                <!--                性别-->
                <div class="mb-3 mt-3">
                  <h4>性别</h4>
                </div>
                <div class="form-check form-check-inline form-group">
                  <input class="form-check-input" type="radio" name="exampleRadios" id="maleSex"
                         value="1" checked>
                  <label class="form-check-label" for="maleSex">
                    男
                  </label>
                </div>
                <div class="form-check form-check-inline form-group">
                  <input class="form-check-input" type="radio" name="exampleRadios" id="femaleSex"
                         value="0">
                  <label class="form-check-label" for="femaleSex">
                    女
                  </label>
                </div>
                <div class="form-check form-check-inline form-group">
                  <input class="form-check-input" type="radio" name="exampleRadios" id="elseSex"
                         value="2">
                  <label class="form-check-label" for="elseSex">
                    其它
                  </label>
                </div>

                <!--                提交按钮-->
                <br>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
              </form>
            </div>
          </div>

        </div>
      </div>
    </section>
  </main>
  </body>
</html>
