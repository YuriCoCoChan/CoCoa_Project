<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CoCo
  Date: 2021/3/1
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/icons-1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/user_manager.css">
    <script type="text/javascript" src="js/jquery3.5.1-min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/user_manager.js"></script>
    <script type="text/javascript" src="js/page.js"></script>
</head>
<body>
<script type="text/javascript">
    var pageCount = parseInt("${requestScope.pageBean.pageCount}");
    var pageIndex = parseInt("${requestScope.pageBean.pageIndex}");
</script>
<%--分页--%>
>
<header>
    <section class="container fixed-top">
        <%--        <nav aria-label="...">
                    <ul class="pagination pagination-lg">
                        <li class="page-item disabled">
                            <span class="page-link">Previous</span>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item active" aria-current="page">
                            <span class="page-link">2</span>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">Next</a>
                        </li>
                    </ul>
                </nav>--%>
        <c:choose>
            <%--            当总页数只有一页时--%>
            <c:when test="${requestScope.pageBean.pageCount==1}">
                <nav aria-label="...">
                    <ul class="pagination pagination-lg">
                        <li class="page-item disabled">
                            <span class="page-link">Previous</span>
                        </li>

                            <%--            当前页            --%>
                        <li class="page-item active">
                            <a class="page-link" href="#">1</a>
                        </li>

                        <li class="page-item disabled">
                            <span class="page-link">下一页[Next]</span>
                        </li>
                    </ul>
                </nav>
            </c:when>

            <%--            当前页数 等于 总页数时  下一页. 尾页失效--%>
            <c:when test="${requestScope.pageBean.pageIndex==requestScope.pageBean.pageCount}">
                <c:choose>
                    <c:when test="${requestScope.pageBean.pageCount==2&&requestScope.pageBean.pageIndex==2}">
                        <nav aria-label="...">
                            <ul class="pagination pagination-lg">
                                <li class="page-item"><a
                                        href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}"><span
                                        class="page-link">上一页[Previous]</span></a></li>
                                    <%--          上一页              --%>
                                <li class="page-item"><a
                                        href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}"
                                        class="page-link">${requestScope.pageBean.pageIndex-1}</a>
                                </li>

                                    <%--                        当前页--%>
                                <li class="page-item active" aria-current="page"><span
                                        class="page-link">${requestScope.pageBean.pageIndex}</span></li>
                                    <%--                        下一页--%>
                                <li class="page-item disabled"><span class="page-link">下一页[Next]</span>
                                </li>
                            </ul>
                        </nav>
                    </c:when>
                    <c:otherwise>
                        <nav aria-label="...">
                            <ul class="pagination pagination-lg">
                                <li class="page-item"><a class="page-link"
                                                         href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}">上一页[Previous]</a>
                                </li>
                                    <%--                        上上页--%>
                                <li class="page-item"><a class="page-link"
                                                         href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-2}">${requestScope.pageBean.pageIndex-2}</a>
                                </li>
                                    <%--                        上一页--%>
                                <li class="page-item"><a class="page-link"
                                                         href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}">${requestScope.pageBean.pageIndex-1}</a>
                                </li>

                                    <%--           当前页             --%>
                                <li class="page-item active" aria-current="page"><span
                                        class="page-link">${requestScope.pageBean.pageIndex}</span></li>

                                <li class="page-item disabled"><span class="page-link">下一页[Next]</span>
                                </li>
                            </ul>
                        </nav>
                    </c:otherwise>
                </c:choose>
            </c:when>

            <%--        [可能多写了]    处于第二页少于正常一页--%>
            <c:when test="${requestScope.pageBean.pageIndex==2&&requestScope.pageBean.pageCount==2}">
                <nav aria-label="...">
                    <ul class="pagination pagination-lg">
                        <li class="page-item"><a
                                href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}"><span
                                class="page-link">上一页[Previous]</span></a></li>
                            <%--          上一页              --%>
                        <li class="page-item"><a
                                href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}"
                                class="page-link">${requestScope.pageBean.pageIndex-1}</a>
                        </li>

                            <%--                        当前页--%>
                        <li class="page-item active" aria-current="page"><span
                                class="page-link">${requestScope.pageBean.pageIndex}</span></li>
                            <%--                        下一页--%>
                        <li class="page-item disabled"><span class="page-link">下一页[Next]</span>
                        </li>
                    </ul>
                </nav>
            </c:when>

            <%--            当处于第一页时且对总页数大于或小于三做出判断--%>
            <c:when test="${requestScope.pageBean.pageIndex==1}">
                <c:choose>
                    <c:when test="${requestScope.pageBean.pageCount>=3}">
                        <nav aria-label="...">
                            <ul class="pagination pagination-lg">
                                <li class="page-item disabled"><span
                                        class="page-link">上一页[Previous]</span></li>
                                    <%--          当前页              --%>
                                <li class="page-item active"><a
                                        class="page-link">${requestScope.pageBean.pageIndex}</a>
                                </li>

                                    <%--                        下一页--%>
                                <li class="page-item" aria-current="page"><a
                                        href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+1}"
                                        class="page-link">${requestScope.pageBean.pageIndex+1}</a></li>
                                    <%--                        下下页--%>
                                <li class="page-item"><a class="page-link"
                                                         href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+2}">${requestScope.pageBean.pageIndex+2}</a>
                                </li>
                                    <%--                        下一页--%>
                                <li class="page-item"><a class="page-link"
                                                         href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+1}">下一页[Next]</a>
                                </li>
                            </ul>
                        </nav>

                    </c:when>

                    <c:when test="${requestScope.pageBean.pageCount<3}">
                        <nav aria-label="...">
                            <ul class="pagination pagination-lg">
                                <li class="page-item disabled"><span
                                        class="page-link">上一页[Previous]</span></li>
                                    <%--          当前页              --%>
                                <li class="page-item active"><a
                                        class="page-link">${requestScope.pageBean.pageIndex}</a>
                                </li>

                                    <%--                        下一页--%>
                                <li class="page-item" aria-current="page"><a
                                        href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+1}"
                                        class="page-link">${requestScope.pageBean.pageIndex+1}</a></li>
                                    <%--                        下一页--%>
                                <li class="page-item"><a class="page-link"
                                                         href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+1}">下一页[Next]</a>
                                </li>
                            </ul>
                        </nav>
                    </c:when>
                </c:choose>
            </c:when>

            <%--            都不达成 则正常--%>
            <c:otherwise>
                <nav aria-label="...">
                    <ul class="pagination pagination-lg">
                        <li class="page-item"><a
                                href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}"><span
                                class="page-link">上一页[Previous]</span></a></li>
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}">${requestScope.pageBean.pageIndex-1}</a>
                        </li>

                            <%--           当前页             --%>
                        <li class="page-item active" aria-current="page"><span
                                class="page-link">${requestScope.pageBean.pageIndex}</span></li>

                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+1}">${requestScope.pageBean.pageIndex+1}</a>
                        </li>
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+1}">下一页[Next]</a>
                        </li>
                    </ul>
                </nav>
            </c:otherwise>
        </c:choose>
    </section>
</header>

<%--分页 JS 版--%>
<%-->
<header>
    <section class="container fixed-top">
        <nav aria-label="...">
            <ul class="pagination pagination-lg">
                <li class="page-item" id="previousButton"><a
                        href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}"><span
                        class="page-link">上一页[Previous]</span></a></li>
                <li class="page-item" id="first"><a class="page-link"
                                                    href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex-1}">${requestScope.pageBean.pageIndex-1}</a>
                </li>

                &lt;%&ndash;           当前页             &ndash;%&gt;
                <li class="page-item active" aria-current="page" id="center"><span
                        class="page-link">${requestScope.pageBean.pageIndex}</span></li>

                <li class="page-item" id="last"><a class="page-link"
                                                   href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+1}">${requestScope.pageBean.pageIndex+1}</a>
                </li>
                <li class="page-item" id="nextButton"><a class="page-link"
                                                         href="${pageContext.request.contextPath}/user_system?pageIndex=${requestScope.pageBean.pageIndex+1}">下一页[Next]</a>
                </li>
            </ul>
        </nav>
    </section>
</header>--%>

<main>
    <section class="container-fluid">
        <div class="row mt-5 p-5">
            <div>
                <h1 class="text-white-50">账户管理</h1>
            </div>
        </div>
        <div class="row mt-5">
            <table class="table table-dark table-striped my-table-hover" id="userManager">
                <thead>
                <tr>
                    <th>注册编号</th>
                    <th>账户名</th>
                    <th>性别</th>
                    <th>生日</th>
                    <th>年龄</th>
                    <th>电话号码</th>
                    <th>注册时间</th>
                    <th>用户组</th>
                    <th>住址</th>
                    <th>账户状态</th>
                    <th colspan="3">业务操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.users}" var="user">
                    <tr>
                        <td name="userId">${user.userId}</td>
                        <td>${user.userName}</td>
                        <td>
                                <%--                                ${user.userSex eq null?"未设置":user.userSex}--%>
                            <c:choose>
                                <c:when test="${user.userSex==0}">女</c:when>
                                <c:when test="${user.userSex==1}">男</c:when>
                                <c:when test="${user.userSex==2}">其它</c:when>
                                <c:otherwise>未设置</c:otherwise>
                            </c:choose>
                        </td>
                        <td>${user.userBirth eq null?"未设置":user.userBirth}</td>
                        <td>${user.userAge eq null?"未设置":user.userAge}</td>
                        <td>${user.userTele eq null?"未设置":user.userTele}</td>
                        <td>${user.userRegisteredDate}</td>
                        <td name="groupName">${user.userGroupName}</td>
                        <td>${user.liveProvincial}-${user.liveCity}</td>
                        <td>${user.userStatus}</td>
                        <!--                    业务操作-->
                        <td class="dropdown">
                            <button type="button" class="btn btn-outline-success dropdown-toggle"
                                    id="dropdownMenuUserGroup" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">账户组调整
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuUserGroup">
                                <c:forEach items="${requestScope.groupName}" var="name">
                                    <button type="button" class="btn dropdown-item " name="userGroupButton"
                                            value="${name.userGroupId}-${user.userId}">${name.userGroupName}
                                    </button>
                                </c:forEach>
                            </div>
                        </td>
                        <td class="dropdown">
                            <button type="button" class="btn btn-outline-warning dropdown-toggle"
                                    id="dropdownMenuStatus" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false">StatusChange
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuStatus">
                                <button type="button" class="btn dropdown-item " name="statusButton"
                                        value="NORMAL-${user.userId}">Normal
                                </button>
                                <button type="button" class="btn dropdown-item " name="statusButton"
                                        value="BANNED-${user.userId}">Banned
                                </button>
                            </div>
                        </td>
                        <td>
                            <button type="button" class="btn btn-outline-danger" name="deleteButton"
                                    value="${user.userId}">Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</main>
</body>
</html>