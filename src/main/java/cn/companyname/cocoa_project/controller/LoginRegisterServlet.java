package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.model.po.UserPO;
import cn.companyname.cocoa_project.service.IUserService;
import cn.companyname.cocoa_project.service.impl.UserServiceImpl;
import cn.companyname.cocoa_project.utils.JsonUtil;
import cn.companyname.cocoa_project.utils.RegExmUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 注册
 *
 * @author CoCo
 */
@WebServlet(name = "LoginRegisterServlet", value = "/login_reg")
public class LoginRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        UserPO userPo = new UserPO();
        String username = request.getParameter("usernameReg");
        String password = request.getParameter("pswReg");
        String emailOrMobile = request.getParameter("emailOrTel");
        if (username == null || password == null || emailOrMobile == null || "".equals(username.trim()) || "".equals(password.trim()) || "".equals(emailOrMobile.trim())) {
            JsonUtil.doJson("Reg Failed,Null Or Undefined", response);
        }
        userPo.setUsername(username);
        userPo.setPassword(password);
        if (RegExmUtil.checkMobile(emailOrMobile)) {
            userPo.setMobile(emailOrMobile);
        } else {
            userPo.setEmail(emailOrMobile);
        }
        IUserService service = new UserServiceImpl();
        int count = service.insertUser(userPo);
        if (count == 0) {
            System.out.println(count);
            JsonUtil.doJson("Reg Failed,User already existed", response);
            return;
        }
        if (count > 1) {
            System.out.println(count);
            JsonUtil.doJson("Reg Failed,Unknown Error", response);
            return;
        }
        if (count == 1) {
            System.out.println(count);
            JsonUtil.doJson("Reg Success", response);
            return;
        }

    }
}
