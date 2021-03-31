package cn.companyname.cocoa_project.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author CoCo
 */
public class MybatisUtil {
    private static SqlSessionFactory factory = null;

    static {
        try {
            String mybatisConfigUrl = "mybatis.xml";
            InputStream is = Resources.getResourceAsStream(mybatisConfigUrl);
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return factory.openSession();
    }

    public static SqlSession getSqlSession(boolean bool) {
        return factory.openSession(bool);
    }
}
