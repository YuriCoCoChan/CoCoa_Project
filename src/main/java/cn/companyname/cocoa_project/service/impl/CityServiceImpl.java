package cn.companyname.cocoa_project.service.impl;

import cn.companyname.cocoa_project.dao.ICityDao;
import cn.companyname.cocoa_project.dao.impl.CityDaoImpl;
import cn.companyname.cocoa_project.service.ICityService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author CoCo
 */
public class CityServiceImpl implements ICityService {
    private ICityDao dao;

    public CityServiceImpl() {
        dao = new CityDaoImpl();
    }

    /**
     * 查询所有城市
     *
     * @param id      请求省会
     * @return ;
     */
    @Override
    public List listCity(int id) {
        List list = dao.listCity(id);
        if (list.size() == 0) {
            return null;
        }
        return list;
    }
}
