package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.service.ICityService;
import cn.companyname.cocoa_project.service.impl.CityServiceImpl;
import cn.companyname.cocoa_project.utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询城市
 *
 * @author CoCo
 */
@WebServlet(name = "CityServlet", value = "/city")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("provincialId"));
        ICityService service = new CityServiceImpl();
        List list = service.listCity(id);
        JsonUtil.doJson(list, response);
    }
}
