package cn.companyname.cocoa_project.dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 多次用到的方法
 *
 * @author CoCo
 */
public interface IBaseDao {
    /**
     * CUD
     *
     * @param sql  执行sql语句
     * @param list 值对象
     * @return ;
     */
    Integer doUpdates(String sql, List list);
}
