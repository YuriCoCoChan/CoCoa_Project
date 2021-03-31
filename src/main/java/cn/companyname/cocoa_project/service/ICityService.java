package cn.companyname.cocoa_project.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author CoCo
 */
public interface ICityService {
    /**
     * 查询所有城市
     *
     * @param id      请求省会
     * @return ;
     */
    List listCity(int id);
}
