package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.model.bean.PageBean;
import cn.companyname.cocoa_project.model.po.UserGroupPO;
import cn.companyname.cocoa_project.model.vo.UserManagerVO;
import cn.companyname.cocoa_project.service.IUserGroupService;
import cn.companyname.cocoa_project.service.IUserService;
import cn.companyname.cocoa_project.service.impl.UserGroupServiceImpl;
import cn.companyname.cocoa_project.service.impl.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author CoCo
 */
@WebServlet(name = "ToUserSystemServlet", value = "/user_system")
public class ToUserSystemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取账户数据 同时进行分页
        PageBean pageBean = new PageBean();
        String pageIndex = request.getParameter("pageIndex");
        if (pageIndex == null) {
            pageBean.setPageIndex(1);
        } else {
            pageBean.setPageIndex(Integer.valueOf(pageIndex));
        }
//        每页数据量
        pageBean.setPageLimit(1);
        IUserService userService = new UserServiceImpl();
        PageHelper.startPage(pageBean.getPageIndex(), pageBean.getPageLimit());
        List<UserManagerVO> users = userService.listAllUser();
        PageInfo<UserManagerVO> pageInfo = new PageInfo<>(users);
//        总数据
        pageBean.setDataCount((int) pageInfo.getTotal());
//        总页数
        pageBean.setPageCount();
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("users", users);
//        获取用户组数据
        IUserGroupService groupService = new UserGroupServiceImpl();
        List<UserGroupPO> groupNames = groupService.listUsersGroup();
        request.setAttribute("groupName", groupNames);
        request.getRequestDispatcher("user_manager.jsp").forward(request, response);
    }
}
