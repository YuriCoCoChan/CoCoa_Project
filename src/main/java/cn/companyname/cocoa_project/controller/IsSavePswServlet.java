package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.utils.GetTimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 来自登录页面 判断是否存cookie [登录页面 ajax请求]
 *
 * @author CoCo
 */
@WebServlet(name = "isSavePswServlet", value = "/checksave")
public class IsSavePswServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            String isSavePsw = (String) session.getAttribute("isSavePsw");
            final String isTrue = "1";
            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);
            int saveTime = 60 * 60 * 24 * 3;
            if (isTrue.equals(isSavePsw)) {
                usernameCookie.setMaxAge(saveTime);
                passwordCookie.setMaxAge(saveTime);
            } else {
                usernameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
            }
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
            session.removeAttribute("isSavePsw");
            session.removeAttribute("password");
            response.sendRedirect(request.getContextPath() + "/mainindex");
            return;
        }
        response.sendRedirect(request.getContextPath() + "/mainindex");
    }
}
