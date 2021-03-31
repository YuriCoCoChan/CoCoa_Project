package cn.companyname.cocoa_project.listener;

import cn.companyname.cocoa_project.utils.JdbcUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 监听器模拟数据库连接池
 *
 * @author CoCo
 */
public class JdbcListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Map map = new HashMap();
            for (int i = 0; i < 20; i++) {
                Connection connection = JdbcUtil.getCon();
                System.out.println("产生连接");
                //true表示这个通道处于空闲状态,false通道正在被使用
                map.put(connection, true);
            }
            ServletContext application = sce.getServletContext();
            application.setAttribute("key1", map);
            //为了Http服务器运行期间 一直都可以用这二十个Connection 将connection保存
            //到全局作用域对象
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//map被销毁
    //在http服务器关闭时刻 将全局作用域对象20个connection销毁

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        Map map = (Map) application.getAttribute("key1");
        Iterator it = map.keySet().iterator();
        try {
            while (it.hasNext()) {
                Connection con = (Connection) it.next();
                if (con != null) {
                    System.out.println("连接关闭!!");
                    con.close();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
