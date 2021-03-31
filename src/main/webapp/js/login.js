$(function () {
    /**
     * 判断表单项是否通过
     * true 表示通过
     * false 则否
     */

    var filterUserName = false;
    var filterPassword = false;
    var filterConfirmPsw = false;
    var filterEmail_Mobile = false;
    /**
     * 登录账户表单
     * @type {jQuery|HTMLElement}
     */
    var usernameLogin = $("[name='usernameLogin']");
    /**
     * 登录密码表单
     * @type {jQuery|HTMLElement}
     */
    var pswLogin = $("[name='pswLogin']");
    /**
     * 登录提交表单 btn
     * @type {jQuery|HTMLElement}
     */
    var subBtnLogin = $("#submitLogin")

    /**
     * 注册账户表单项
     */
    var usernameReg = $("[name='usernameReg']");

    /**
     * 注册登录表单项
     */
    var pswReg = $("[name='pswReg']");

    /**
     * 注册确认密码表单项
     */
    var pswConfirmReg = $("[name='pswRegConfirm']");

    /**
     * 注册 电话 | 邮箱 表单项
     */
    var emailOrTelReg = $("[name='emailOrTel']");

    /**
     * 注册 提交按钮
     */
    var submitBtnReg = $("#submitRegister");


    $("i").css({
        "font-size": "20px",
        "color": "rgba(255,255,255,0.4)"
    });

    $("i").hover(function () {
        $(this).css("color", "rgba(255,255,255,1)")
    }, function () {
        $(this).css("color", "rgba(255,255,255,0.4)")
    });
    /**
     * 判断是否为空 则判断 是否保存密码的选中状态
     */
    if (usernameLogin.val() != "" && pswLogin.val() != "") {
        $("[name='savePsw']").prop("checked", "checked")
    }

    /**
     * 检查 账户 是否合法通过
     */
    function checkName(param) {
        var usernameRegExp = /^([a-zA-Z0-9]+[_]?){4,22}()$/
        var isTrue = usernameRegExp.test(param.val())
        if (!isTrue ? filterUserName = false : filterUserName = true) ;
    }

    /**
     * 检查 密码 是否合法通过
     */
    function checkPsw(param) {
        if (param.val().length < 6 || param.val().length > 40 ? filterPassword = false : filterPassword = true) ;
    }

    function checkPswConfirm(paramOne, paramTwo) {
        if (paramOne.val() != paramTwo.val() ? filterConfirmPsw = false : filterConfirmPsw = true) ;
    }

    function judgment_checkEmail_Mobile(param) {
        // 手机号正则表达式 更新于 20.9.25
        var MobileRegExp = /^1(3([0-35-9]\d|4[1-8])|4[14-9]\d|5([0-35689]\d|7[1-79])|66\d|7[2-35-8]\d|8\d{2}|9[13589]\d)\d{7}$/
        var isMobile = MobileRegExp.test(param.val())
        // 邮箱正则表达式
        var emailRegExp = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
        var isEmail = emailRegExp.test(param.val())
        if (isEmail || isMobile) {
            filterEmail_Mobile = true;
        } else {
            filterEmail_Mobile = false;
            return false;
        }

    }


    /**
     * 密码是否可视化
     */
    $("#seePsw").click(function () {
        if ($(this).prop("checked")) {
            pswLogin.attr("type", "text")
        } else {
            pswLogin.attr("type", "password")
        }
    })

    /**
     * 账户项 键盘监听
     */
    usernameLogin.keydown(function (e) {
        var keyCode = e.keyCode;
        if ((keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122) || (keyCode >= 48 && keyCode <= 57)) {
            return true;
        }

        if (keyCode == 13) {// enter
            checkName(usernameLogin);
            if (filterUserName) {
                pswLogin.focus();
            }
            e.preventDefault();
            return false;
        }
        if (keyCode == 9) {//tab
            checkName(usernameLogin);
            if (!filterUserName) {
                alert("填写方式不正确!不给予换行")
                e.preventDefault();
                return false;
            }
        }
    });

    pswLogin.keydown(function (e) {
        if (e.keyCode == 9 && pswLogin.val() == "" || e.keyCode == 9 && pswLogin.val().length < 6) {
            alert('填写方式不正确!不给予换行')
            e.preventDefault();
            return false;
        }
        if (e.keyCode == 13) {
            return passLoginSubmit();
        }


    })

    /**
     * 失去焦点判断是否正确 不正确提示 [还没有写!!]
     * 但是有防止恶意通过后   又删除的操作 的作用
     */
    usernameLogin.blur(function () {
        checkName(usernameLogin);
    });

    pswLogin.blur(function () {
        checkPsw(pswLogin);
    })

    /**
     * 提交按钮 [划过] 背景变色
     */

    subBtnLogin.click(function () {
        passLoginSubmit();
    })


    /*
    * Register
    *
    * */

    usernameReg.keydown(function (e) {
        var keyCode = e.keyCode;
        if ((keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122) || (keyCode >= 48 && keyCode <= 57)) {
            return true;
        }
        if (keyCode == 13) {// enter
            checkName(usernameReg);
            if (filterUserName) {
                pswLogin.focus();
            }
            e.preventDefault();
            return false;
        }
        if (keyCode == 9) {//tab
            checkName(usernameReg);
            if (!filterUserName) {
                alert("填写方式不正确!不给予换行")
                e.preventDefault();
                return false;
            }
        }
    })

    pswReg.keydown(function (e) {
        if (e.keyCode == 9 && pswReg.val() == "" || e.keyCode == 9 && pswReg.val().length < 6) {
            alert('填写方式不正确!不给予换行')
            e.preventDefault();
            return false;
        }
        if (e.keyCode == 13 && pswReg.val() == "" || e.keyCode == 13 && pswReg.val().length < 6) {
            alert('填写方式不正确!不给予换行')
            e.preventDefault();
            return false;
        }
    })

    pswConfirmReg.keydown(function (e) {
        if (e.keyCode == 9 && pswConfirmReg.val() == "" || e.keyCode == 9 && pswConfirmReg.val().length < 6) {
            alert('填写方式不正确!不给予换行')
            e.preventDefault();
            return false;
        }
        if (e.keyCode == 13 && pswConfirmReg.val() == "" || e.keyCode == 13 && pswConfirmReg.val().length < 6) {
            alert('填写方式不正确!不给予换行')
            e.preventDefault();
            return false;
        }
        if (e.keyCode == 9 && pswConfirmReg.val() != pswReg.val() || e.keyCode == 13 && pswConfirmReg.val() != pswReg.val()) {
            alert("确认密码不一致")
            pswConfirmReg.val("")
            e.preventDefault();
            return false;
        }
        if (e.keyCode == 13) {
            checkPswConfirm(pswConfirmReg, pswReg);
            if (filterConfirmPsw) {
                emailOrTelReg.focus();
            }
        }
    });

    emailOrTelReg.keydown(function (e) {
        var keyCode = e.keyCode;
        if ((keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122) || (keyCode >= 48 && keyCode <= 57)) {
            return true;
        }
        if (keyCode == 13) {// enter
            if (usernameReg.val() != "" && pswReg.val() != "" && pswConfirmReg.val() != "" && emailOrTelReg.val() != "") {
                checkName(usernameReg);
                checkPsw(pswReg);
                checkPswConfirm(pswConfirmReg, pswReg);
                judgment_checkEmail_Mobile(emailOrTelReg);
                return passRegSubmit();
            }
            e.preventDefault();
            return false;
        }
        if (keyCode == 9) {//tab
            judgment_checkEmail_Mobile(emailOrTelReg);
            if (!filterEmail_Mobile) {
                alert("邮箱格式或手机格式不正确!不给予换行");
                e.preventDefault();
                return false;
            }
        }
    });

    submitBtnReg.click(function () {
        if (usernameReg.val() != "" && pswReg.val() != "" && pswConfirmReg.val() != "" && emailOrTelReg.val() != "") {
            checkName(usernameReg);
            checkPsw(pswReg);
            checkPswConfirm(pswConfirmReg, pswReg);
            judgment_checkEmail_Mobile(emailOrTelReg);
            return passRegSubmit();
        } else {
            alert("任意填写框不许为空")
        }
    });

    /**
     * 验证以及提交
     */
    function stopInterval(param) {
        clearInterval(param)
    }

    function countTime(elements, time) {
        var timeInter = setInterval(function () {
            elements.text(time + "秒后将自动跳转首页");
            if (time == 0) {
                stopInterval(timeInter);
                elements.text("")
            }
            time--;
        }, 1000)
    }

    function callbackLogin(resp) {
        if (resp == "Login Failed") {
            console.log(resp)
            alert("登录失败,账号或密码错误")
            return;
        }
        if (resp.userId != null) {
            console.log(resp.userId)
            console.log(resp.username)
            console.log(resp.avatarImgSrc)
            console.log(resp.groupId)
            $("#welcomeName").text(resp.username);
            $("#frmWelcome img").prop("src", "${pageContext.request.contextPath}" + resp.avatarImgSrc)
            alert("登录成功!")
            $("#workFrm").hide(500);
            setTimeout(function () {
                $("#frmWelcome").show(500)
            }, 500);
            countTime($('#second'), 3);
            setTimeout(function () {
                location.href = "${pageContext.request.contextPath}/checksave"
            }, 5000)
        } else {
            alert("哎呀 发生了错误 请重试(✺ω✺)")
            return;
        }
    }

    function passLoginSubmit() {
        checkName(usernameLogin);
        checkPsw(pswLogin);
        if (filterUserName && filterPassword) {
            $.post("login", $("#loginForm").serialize(), callbackLogin, "json")
        } else {
            alert("填写方式不正确!不给予提交")
        }
    }

    function callbackReg(resp) {
        if ("Reg Failed,User already existed" == resp) {

            console.log(resp);
            usernameReg.text("");
            usernameReg.focus();
            alert("账户已存在");
            return;
        }
        if ("Reg Failed,Unknown Error" == resp) {
            console.log(resp);
            alert("未知错误请重试");
            return;
        }
        if ("Reg Success" == resp) {
            console.log(resp);
            alert("注册成功");
            $("#registerStatus").fadeOut(500)
            $("#nav-reg-link").fadeOut(500)
            $("#loginStatus").fadeIn(500)
            $("#nav-log-link").css({
                "background-color": "rgba(255, 255, 255, 0.4)",
                "font-color": "black"
            });
            return;
        }

    }

    function passRegSubmit() {
        checkName(usernameReg);
        checkPsw(pswConfirmReg, pswReg)
        judgment_checkEmail_Mobile(emailOrTelReg)
        if (filterUserName && filterPassword && filterConfirmPsw && filterEmail_Mobile) {
            $.post("login_reg", $("#formReg").serialize(), callbackReg, "json")
        } else {
            alert("填写方式不正确!不给予提交")
        }
    }

    function loginNull() {
        usernameLogin.val("")
        pswLogin.val("")
        $("[name='savePsw']").prop("checked", false)

    }

    $("#nav-log-link").click(function () {
        loginNull();
    })

    $("#nav-reg-link").click(function () {
        loginNull();
        usernameReg.val("");
        pswReg.val("")
        pswConfirmReg.val("");
        emailOrTelReg.val("")
    })


});// $(function())

