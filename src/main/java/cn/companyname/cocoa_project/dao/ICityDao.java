package cn.companyname.cocoa_project.dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author CoCo
 */
public interface ICityDao {
    /**
     * 查询所有城市
     * @param id 请求省会
     * @return ;
     */
    List listCity(int id);
}
