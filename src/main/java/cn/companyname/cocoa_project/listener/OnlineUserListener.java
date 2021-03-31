package cn.companyname.cocoa_project.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 在线人数
 *
 * @author CoCo
 * @date 2021年3月8日01:01:43
 */
@WebListener
public class OnlineUserListener implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        Integer countOnline = 0;
        application.setAttribute("countOnline", countOnline);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext application = httpSessionEvent.getSession().getServletContext();
        Integer countOnline = (int) application.getAttribute("countOnline");
        countOnline++;
        application.setAttribute("countOnline", countOnline);
        System.out.println("在线人数" + countOnline);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext application = httpSessionEvent.getSession().getServletContext();
        Integer countOnline = (int) application.getAttribute("countOnline");
        countOnline--;
        application.setAttribute("countOnline", countOnline);
        System.out.println("在线人数" + countOnline);
    }
}
