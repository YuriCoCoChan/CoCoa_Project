package cn.companyname.cocoa_project.dao.impl;

import cn.companyname.cocoa_project.dao.ICityDao;
import cn.companyname.cocoa_project.model.po.CityPO;
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
public class CityDaoImpl implements ICityDao {

    /**
     * 查询所有城市
     *
     * @param id      请求省会
     * @return ;
     */
    @Override
    public List listCity(int id) {
        List list = new ArrayList();
        ResultSet resultSet = null;
        String sql = "select city_id,city_name from city where provincial_id = ?";
        PreparedStatement ps = JdbcUtil.getPreparedStatement(sql);
        CityPO cityPo = null;
        try {
            ps.setInt(1, id);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                cityPo = new CityPO();
                cityPo.setCityId(resultSet.getInt("city_id"));
                cityPo.setCityName(resultSet.getString("city_name"));
                list.add(cityPo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet);
            JdbcUtil.close();
        }
        return list;
    }
}
