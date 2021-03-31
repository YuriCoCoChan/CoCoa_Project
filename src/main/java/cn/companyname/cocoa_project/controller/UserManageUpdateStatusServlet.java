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
@WebServlet(name = "UserManageUpdateStatusServlet", value = "/user_status")
public class UserManageUpdateStatusServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("values");
        String userStatus = value.split("-")[0];
        Integer userId = Integer.valueOf(value.split("-")[1]);
        IUserService service = new UserServiceImpl();
        int rs = service.updateUserStatusById(userStatus, userId);
        JsonUtil.doJson(rs, response);
    }
}
