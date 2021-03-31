package cn.companyname.cocoa_project.dao.mybatis;

import cn.companyname.cocoa_project.model.po.UserGroupPO;

import java.util.List;

/**
 * @author CoCo
 */
public interface IUserGroupDao {
    /**
     * 查询所有用户组名
     *
     * @return
     */
    List<UserGroupPO> listUsersGroup();
}
