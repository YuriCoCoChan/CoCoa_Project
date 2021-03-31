package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.service.IUserService;
import cn.companyname.cocoa_project.service.impl.UserServiceImpl;
import cn.companyname.cocoa_project.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CoCo
 */
@WebServlet(name = "UserManagerDeleteServlet", value = "/delete_user")
public class UserManagerDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserServiceImpl();
        Integer id = Integer.valueOf(request.getParameter("id"));
        int result = 0;
        if (id != null) {
            result = userService.deleteUserById(id);
        }
        System.out.println(result);
        JsonUtil.doJson(result, response);
        /*
         * 使用 ajax 提高用户的体验
         * */
        ;
    }
}
