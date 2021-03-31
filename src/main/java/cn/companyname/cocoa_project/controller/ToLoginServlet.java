package cn.companyname.cocoa_project.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发 登录PAGE || cookie循环
 *
 * @author CoCo
 */
@WebServlet(name = "ToLoginServlet", value = "/tologin")
public class ToLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    request.setAttribute("username", cookie.getValue());
                }
                if ("password".equals(cookie.getName())) {
                    request.setAttribute("password", cookie.getValue());
                }
            }
            request.getRequestDispatcher("/login_reg.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/login_reg.jsp").forward(request, response);
    }
}
