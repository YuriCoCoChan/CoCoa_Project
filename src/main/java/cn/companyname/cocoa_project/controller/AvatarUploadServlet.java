package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.service.IUserService;
import cn.companyname.cocoa_project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 上传头像
 *
 * @author CoCo
 * @date 2021/1/13
 */
@WebServlet(name = "AvatarUploadServlet", value = "/avatar")
@MultipartConfig
public class AvatarUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute("userid");
        String oldPath = (String) session.getAttribute("titlesrc");
        IUserService service = new UserServiceImpl();
        int count = service.updateUser(request);
        if (count == 1) {
            System.out.println("成功");
            response.sendRedirect(request.getContextPath() + "/mainindex");
        } else {
            System.out.println("失败");
        }
    }
}
