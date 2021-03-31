package cn.companyname.cocoa_project.dao.impl;

import cn.companyname.cocoa_project.dao.IBaseDao;
import cn.companyname.cocoa_project.utils.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author CoCo
 */
public class BasedaoImpl implements IBaseDao {
    @Override
    public Integer doUpdates(String sql, List list) {
        PreparedStatement ps = JdbcUtil.getPreparedStatement(sql);
        System.out.println(sql);
        int count = -1;
        try {
            for (int i = 0; i < list.size(); i++) {
                ps.setObject((i + 1), list.get(i));
            }
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return count;
    }
}
