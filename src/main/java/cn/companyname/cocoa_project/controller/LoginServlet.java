package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.model.vo.LoginVO;
import cn.companyname.cocoa_project.service.IUserService;
import cn.companyname.cocoa_project.service.impl.UserServiceImpl;
import cn.companyname.cocoa_project.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录
 *
 * @author CoCo
 */
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("usernameLogin");
        String password = request.getParameter("pswLogin");
        LoginVO loginVo = null;
        IUserService service = new UserServiceImpl();
        loginVo = service.getUser(request, name, password);
        if (loginVo != null) {
            HttpSession session = request.getSession();
            session.setAttribute("isSavePsw", request.getParameter("savePsw"));
            session.setAttribute("password", password);
            session.setAttribute("userid", loginVo.getUserId());
            session.setAttribute("username", name);
            session.setAttribute("groupid", loginVo.getGroupId());
            session.setAttribute("titlesrc", loginVo.getAvatarImgSrc());
            JsonUtil.doJson(loginVo, response);
        } else {
            JsonUtil.doJson("Login Failed", response);
        }


    }

}
