package cn.companyname.cocoa_project.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 记录访站人数
 *
 * @author CoCo
 * @date 2021年3月8日01:01:32
 */
@WebListener
public class AccessUserCountListener implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        Integer countViewsUser = 0;
        application.setAttribute("countViewsUser", countViewsUser);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext application = httpSessionEvent.getSession().getServletContext();
        Integer countViewsUser = (int) application.getAttribute("countViewsUser");
        countViewsUser++;
        application.setAttribute("countViewsUser", countViewsUser);
        System.out.println("总访问站 人数" + countViewsUser);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
