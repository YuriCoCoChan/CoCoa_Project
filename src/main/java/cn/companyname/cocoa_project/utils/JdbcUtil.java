package cn.companyname.cocoa_project.utils;

import com.mysql.cj.jdbc.Driver;
import jdk.nashorn.internal.scripts.JD;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 操作数据库工具
 *
 * @author CoCo
 */
public class JdbcUtil {
    /**
     * 变量
     */
    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;
    private static String driver;
    private static String url;
    private static String name;
    private static String password;

    //静态代码块
    static {
        //读取JDBC配置文件
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.driver = properties.getProperty("driver");
                JdbcUtil.name = properties.getProperty("name");
                JdbcUtil.url = properties.getProperty("url");
                JdbcUtil.password = properties.getProperty("password");
                Class.forName(JdbcUtil.driver);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 连接测试
     *
     * @return ;
     */
    public static boolean getConnectionTest() {
        try {
            connection = DriverManager.getConnection(JdbcUtil.url, JdbcUtil.name, JdbcUtil.password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 普通 JDBC
     *
     * @return ;
     */
    public static Connection getCon() {
        try {
            connection = DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 普通 JDBC
     *
     * @param sql 数据库语句
     * @return ;
     */
    public static PreparedStatement getPs(String sql) {
        try {
            preparedStatement.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * Listener 连接池
     *
     * @param request 请求对象
     * @return ;
     */
    public static Connection getConnection(HttpServletRequest request) {
        //1.通过请求对象,得到全局作用域对象
        ServletContext application = request.getServletContext();
        //2.从全局作用域对象得到Map
        Map map = (Map) application.getAttribute("key1");
        //3.从map得到一个处于空闲状态Connection
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            connection = (Connection) it.next();
            if ((Boolean) map.get(connection)) {
                map.put(connection, false);
                break;
            }
        }
        return connection;
    }

    /**
     * Listener 连接池
     *
     * @param sql     数据库语句
     * @param request 请求对象
     * @return ;
     */
    public static PreparedStatement getPreparedStatement(String sql, HttpServletRequest request) {
        try {
            preparedStatement = getConnection(request).prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static Connection getConnection() {
        try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * 关闭
     */
    public static void close() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(HttpServletRequest request) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        ServletContext application = request.getServletContext();
        Map map = (Map) application.getAttribute("key1");
        map.put(connection, true);
        //通过全局作用域对象得到Connection
    }

}