package cn.companyname.cocoa_project.service.impl;

import cn.companyname.cocoa_project.dao.IProvincialDao;
import cn.companyname.cocoa_project.dao.impl.ProvincialDaoImpl;
import cn.companyname.cocoa_project.service.IProvincialService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author CoCo
 */
public class ProvincialServiceImpl implements IProvincialService {
    private IProvincialDao dao;

    public ProvincialServiceImpl() {
        dao = new ProvincialDaoImpl();
    }

    /**
     * 查询所有省会
     *
     * @return ;
     */
    @Override
    public List listProvincial() {
        List list = dao.listProvincial();
        if (list.size() == 0) {
            return null;
        }
        return list;
    }
}
