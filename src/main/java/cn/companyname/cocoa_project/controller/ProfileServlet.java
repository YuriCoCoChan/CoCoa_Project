package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.model.vo.MainIndexProfileVO;
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
 * 查询浏览器请求的账户个人资料
 *
 * @author CoCo
 * @date 2021/1/12
 */
@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        IUserService service = new UserServiceImpl();
        MainIndexProfileVO profileVo = service.getUser(id);
        JsonUtil.doJson(profileVo, response);
    }
}
