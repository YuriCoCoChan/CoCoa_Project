package cn.companyname.cocoa_project.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 退出登录
 *
 * @author CoCo
 * @date 2021/1/14
 */
@WebServlet(name = "SignOutServlet", value = "/sign_out")
public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session = null;
        response.sendRedirect(request.getContextPath() + "/mainindex");
    }
}
