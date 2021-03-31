package cn.companyname.cocoa_project.dao.impl;


import cn.companyname.cocoa_project.dao.IProvincialDao;
import cn.companyname.cocoa_project.model.po.ProvincialPO;
import cn.companyname.cocoa_project.utils.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CoCo
 */
public class ProvincialDaoImpl implements IProvincialDao {
    /**
     * 查询所有省会
     *
     * @return ;
     */
    @Override
    public List listProvincial() {
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "select provincial_id,provincial_name from provincial";
        PreparedStatement preparedStatement = JdbcUtil.getPreparedStatement(sql);
        ProvincialPO provincialPo = null;
        try {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                provincialPo = new ProvincialPO();
                provincialPo.setProvincialId(rs.getInt("provincial_id"));
                provincialPo.setProvincialName(rs.getString("provincial_name"));
                list.add(provincialPo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close();
        }
        return list;
    }
}
