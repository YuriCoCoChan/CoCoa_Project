package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.model.dto.ProfileDTO;
import cn.companyname.cocoa_project.service.IUserService;
import cn.companyname.cocoa_project.service.impl.UserServiceImpl;
import cn.companyname.cocoa_project.utils.GetTimeUtil;
import cn.companyname.cocoa_project.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CoCo
 * @date 2021/1/12
 */
@WebServlet(name = "SubmitUserProfileServlet", value = "/submituserprofile")
public class SubmitUserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
//        下 修改内容
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setEmail(request.getParameter("email"));
        profileDTO.setMobile(request.getParameter("mobile"));
        profileDTO.setUserBirth(request.getParameter("userBirth"));
        profileDTO.setProvincialId(Integer.valueOf(request.getParameter("userProvincial")));
        profileDTO.setCityId(Integer.valueOf(request.getParameter("userCity")));
        profileDTO.setAge(Integer.valueOf(request.getParameter("age")));
        profileDTO.setSex(Integer.valueOf(request.getParameter("sexRadios")));
        profileDTO.setUserId((Integer) session.getAttribute("userid"));
//        以上为修改内容
        IUserService service = new UserServiceImpl();
        int count = service.updateUser(profileDTO);
        System.out.println(count);
        JsonUtil.doJson(count, response);
    }
}
