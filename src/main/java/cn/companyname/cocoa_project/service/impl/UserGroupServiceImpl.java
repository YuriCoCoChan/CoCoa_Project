package cn.companyname.cocoa_project.service.impl;

import cn.companyname.cocoa_project.dao.mybatis.IUserGroupDao;
import cn.companyname.cocoa_project.model.po.UserGroupPO;
import cn.companyname.cocoa_project.service.IUserGroupService;
import cn.companyname.cocoa_project.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author CoCo
 */
public class UserGroupServiceImpl implements IUserGroupService {

    @Override
    public List<UserGroupPO> listUsersGroup() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserGroupDao groupDao = sqlSession.getMapper(IUserGroupDao.class);
        return groupDao.listUsersGroup();
    }
}
