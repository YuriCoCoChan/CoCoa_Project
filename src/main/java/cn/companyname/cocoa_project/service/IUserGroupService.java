package cn.companyname.cocoa_project.service;

import cn.companyname.cocoa_project.model.po.UserGroupPO;

import java.util.List;

/**
 * @author CoCo
 */
public interface IUserGroupService {
    /**
     * 查询所有用户组
     *
     * @return ;
     */
    List<UserGroupPO> listUsersGroup();
}
