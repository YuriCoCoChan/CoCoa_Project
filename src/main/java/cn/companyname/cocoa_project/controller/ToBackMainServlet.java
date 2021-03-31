package cn.companyname.cocoa_project.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CoCo
 * @date 2021年3月9日16:41:41
 */
@WebServlet(name = "ToBackMainServlet",value = "/backmain")
public class ToBackMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/background_main_index.jsp").forward(request, response);

    }
}
