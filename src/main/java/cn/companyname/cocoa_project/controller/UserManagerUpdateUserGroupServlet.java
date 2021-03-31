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
 * @date 2021年3月5日12:04:46
 */
@WebServlet(name = "UserManagerUpdateUserGroupServlet", value = "/user_group")
public class UserManagerUpdateUserGroupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String values = request.getParameter("values");
        Integer userId = Integer.valueOf(values.split("-")[1]);
        Integer groupId = Integer.valueOf(values.split("-")[0]);
        IUserService service = new UserServiceImpl();
        int rs = service.updateUserGroupById(userId, groupId);
        JsonUtil.doJson(rs, response);
    }

}
