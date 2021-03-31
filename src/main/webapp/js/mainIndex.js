/**
 * @author CoCo
 */
$(function () {

    $(window).scroll(function () {
        if ($(document).scrollTop() >= 250) {
            $("#scrollNav").fadeIn();
        } else if ($(document).scrollTop() <= 70) {
            $("#scrollNav").fadeOut();
        }
    })

    var userTitle = $("#userTitle");
    var downlist = $("#downlist");
    /**
     * 判断登录
     */
    if ("${sessionScope.username}" != "") {
        // console.log("已登录")
        $("#loginHref").remove();
        setTimeout(function () {
            userTitle.css({
                "display": "list-item",
                "background-image": "url('${pageContext.request.contextPath}/${sessionScope.titlesrc}')",
                "background-size": "cover",
                "height": "45px",
                "width": "45px"
            })
            $("#titleShowFrm").css({
                "background-image": "url('${pageContext.request.contextPath}/${sessionScope.titlesrc}')",
                "background-size": "cover",
                "height": "150px",
                "width": "150px"
            })
        }, 200)
    } else {
        console.log("未登录")
    }
    $("i").css({
        "font-size": "30px",
        "font-weight": "bold"
    })

    // 计算 轮播图 的高度
    $("#carouselExampleCaptions").css({
        "height": (screen.height * 0.835),
    });

    userTitle.click(function () {
        downlist.css("display", "block")
    });

    /*    userTitle.mouseleave(function () {
            downlist.css("display", "none")
        })*/

    downlist.mouseleave(function () {
        downlist.css("display", "none")
    })

    function getTimeYyyyMmDd() {
        var time = new Date();
        var day = ("0" + time.getDate()).slice(-2);
        var month = ("0" + (time.getMonth() + 1)).slice(-2);
        return time.getFullYear() + "-" + (month) + "-" + (day);
    }

    function getTimeYyyy() {
        var time = new Date();
        return time.getFullYear();
    }

    function callbackProfile(resp) {
        /*        console.log(resp.userGroup)
                console.log(resp.email)
                console.log(resp.mobile)
                console.log(resp.userBirth)
                console.log(resp.userAge)
                console.log(resp.userSex)
                console.log(resp.userProvincial)
                console.log(resp.userCity)*/
        $('[name="username"]').val("${sessionScope.username}")
        $("[name='userGroup']").val(resp.userGroup);
        $("[name = 'email']").val(resp.email);
        $("[name='mobile']").val(resp.mobile)
        $("[name ='userProvincial']").val(resp.userProvincial)
        $("[name ='userCity']").val(resp.userCity)
        //判断生日
        if (resp.userBirth == null) {
            $("[name='userBirth']").val(getTimeYyyyMmDd());
            $("[name='age']").val("");
        } else {
            $("[name='userBirth']").val(resp.userBirth);
            $("[name='age']").val(resp.userAge)
        }
        //判断性别
        if (resp.userSex == 1) {
            $("#maleSex").prop("checked", true)
        } else if (resp.userSex == 0) {
            $("#femaleSex").prop("checked", true)
        } else {
            $("#elseSex").prop("checked", true)
        }
        //判断是否已选省份城市信息
        if (resp.userProvincial != null || resp.userProvincial != 0) {
            $.get("city", {"provincialId": $("#inputProvincial").select().val()}, callbackCity, "json")
            setTimeout(function () {
                $("#inputState").select().val(resp.userCity)
            }, 100)
        }

    }

    $("#downlist button:first").click(function () {
        $("#inputEmail1").removeClass("is-invalid")
        $("#inputMobile").removeClass("is-invalid")
        $.get("profile", {"id": "${sessionScope.userid}"}, callbackProfile, "json")
    })

    var citys = $("#inputState");

    function callbackCity(resp) {
        citys.empty();
        citys.append("<option value='0'>请选择 </option>")
        $.each(resp, function (i, n) {
            citys.append("<option value='" + n.cityId + "'>" + n.cityName + "</option>");
        })
    }

    $("#inputProvincial").change(function () {
        $.get("city", {"provincialId": $(this).select().val()}, callbackCity, "json")
    })

    /**
     * 验证 改变个人资料的表单
     */

    function checkMobile() {
        if ($("#inputMobile") != "") {
            // 手机号正则表达式 更新于 20.9.25
            var MobileRegExp = /^1(3([0-35-9]\d|4[1-8])|4[14-9]\d|5([0-35689]\d|7[1-79])|66\d|7[2-35-8]\d|8\d{2}|9[13589]\d)\d{7}$/
            var isMobile = MobileRegExp.test($("#inputMobile").val());
            if (!isMobile) {
                //告知手机格式不对
                if ($("#inputMobile").val() != "") {
                    $("#inputMobile").addClass("is-invalid");
                    $("#mobileHelp").css("display", "none");
                    return false;
                }
            } else {
                $("#mobileHelp").css("display", "block")
                $("#inputMobile").removeClass("is-invalid");
                return true;
            }
        }
    }

    $("#inputMobile").change(function () {
        checkMobile();
    })

    $("#inputEmail1").change(function () {
        checkEmail();
    })

    function checkEmail() {
        if ($("#inputEmail1") != "") {
            // 邮箱正则表达式
            var emailRegExp = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            isEmail = emailRegExp.test($("#inputEmail1").val())
            if (!isEmail) {
                // 告知邮箱格式不对
                if ($("#inputEmail1").val() != "") {
                    $("#inputEmail1").addClass("is-invalid");
                    $("#emailHelp").css("display", "none")
                    return false;
                }
            } else {
                $("#emailHelp").css("display", "block")
                $("#inputEmail1").removeClass("is-invalid");
                return true;
            }
        }
    }

    function checkCity() {
        if ($("#inputState").select().val() == 0) {
            $("#inputState").addClass("is-invalid");
            return false;
        } else {
            $("#inputState").removeClass("is-invalid");
            return true;
        }
    }

    function checkProvincial() {
        if ($("#inputProvincial").select().val() == 0) {
            $("#inputProvincial").addClass("is-invalid")
            return false;
        } else {
            $("#inputProvincial").removeClass("is-invalid")
            return true;
        }
    }

    $("#inputState").change(function () {
        checkCity();
    })

    $("#inputProvincial").change(function () {
        checkProvincial();
    });

    function callbackSubmitProfile(resp) {
        console.log(resp);
        if (resp == '1') {
            alert("change success")
        } else {
            alert("error")
        }

    }

    $("#submitChangeProfile").click(function () {
        if ($("#inputEmail1").val() == "" && $("#inputMobile").val() == "") {
            //     提示 电话和邮箱必须有一个不能为空!
            return;
        }
        var email = checkEmail();
        var mobile = checkMobile();
        var provincial = checkProvincial();
        var city = checkCity();
        // undefined
        if (email == false || mobile == false || provincial == false || city == false) {
            alert("验证不通过");
            return;
        }
        // 判断是否修改生日
        if ($("#date").val() == getTimeYyyyMmDd()) {
            $("#age").val("0")
        }

        // 发送请求
        $.get("submituserprofile", $("#profile").serialize(), callbackSubmitProfile, "json")
        //        出生日期不做要求  [毕竟出生日期暴露年龄]
    })

    $("#date").change(function () {
        //年龄的判断
        var now = getTimeYyyy();
        var dateValue = $(this).val().split('-')[0];
        console.log(dateValue);
        if (dateValue != now)
            $("#age").val(now - dateValue);
    })

    function callBackLoginOut(resp) {
        if (resp === 'y') {
            alert('退出成功');
            location.href = "${pageContext.request.contextPath}/mainindex";
        } else {
            console.log('未知错误')
        }

    }

    $("#loginOut").click(function () {
        $.post("${pageContext.request.contextPath}/login_out", {"null": "null"}, callBackLoginOut, "json")
    })

    /**
     *  上传头像的预览功能
     */
    $("#pictureFile").change(function () {
        var file = $(this).prop('files')[0];
        if (file) {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onloadend = function (even) {
                var url = even.currentTarget.result;
                $("#titleShowFrm").css({
                    "background-image": "url('" + url + "')",
                    "background-size": "cover",
                    "height": "150px",
                    "width": "150px"
                })
            }
        }
    })

    // 上传头像 选了头像 但没有上传 恢复成原来的酱紫
    $("#changeTitleModal").blur(function () {
        $("#titleShowFrm").css({
            "background-image": "url('${pageContext.request.contextPath}/${sessionScope.titlesrc}')",
            "background-size": "cover",
            "height": "150px",
            "width": "150px"
        })
    })

    // 解决 修改个人资料 选择日期改变年龄的BUG ————》
    var date = new Date();
    var maxYear = date.getFullYear();
    var minYear = maxYear - 125;
    var firstMd = "-01-01";
    var lastMd = "-12-31";
    console.log(maxYear)
    var profileBirthDay = $("input[type=date]");
    profileBirthDay.attr('min', minYear + firstMd);
    profileBirthDay.attr('max', (maxYear-5) + lastMd);
    profileBirthDay.keydown(function (e) {
        e.preventDefault();
    })


});// end
