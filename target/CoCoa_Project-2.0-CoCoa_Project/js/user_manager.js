$(function () {
    var userManager = $("#userManager");
    userManager.children().addClass('text-center');
    userManager.children().addClass('text-white');


    /**
     * 执行删除账户的 ajax 返回方法
     * @param resp 返回结果
     */
    function callBackDeleteUser(resp) {
        if (resp == 1) {
            location.href="${pageContext.request.contextPath}/user_system"
        } else {
            alert("未知错误!")
        }
    }

    $("[name='deleteButton']").unbind('click').click(function () {
        $.post("${pageContext.request.contextPath}/delete_user", {"id": $(this).val()}, callBackDeleteUser, "json")
    })


    function callBackUserStatus(resp) {
        console.log(resp);
        if (resp == 1) {
            alert("修改成功");
            location.href = "${pageContext.request.contextPath}/user_system"
        } else {
            alert("failed")
        }

    }

    $("[name='statusButton']").unbind('click').click(function () {
        $.post("${pageContext.request.contextPath}/user_status", {
            "values": $(this).val()
        }, callBackUserStatus, "json")
    })


    function callBackUserGroup(resp) {
        console.log(resp);
        if (resp == 1) {
            alert("修改成功")
            location.href = "${pageContext.request.contextPath}/user_system"

        } else {
            alert("failed")
        }
    }

    $("[name='userGroupButton']").unbind('click').click(function () {
        $.post("${pageContext.request.contextPath}/user_group", {
            "values": $(this).val()
        }, callBackUserGroup, "json")
    })

});