package cn.companyname.cocoa_project.dao.mybatis;

import cn.companyname.cocoa_project.model.vo.UserManagerVO;

import java.util.List;

/**
 * @author CoCo
 */
public interface IUserDao {
    /**
     * 查询 "账户管理系统" 关于账户的数据
     *
     * @return
     */
    List<UserManagerVO> listAllUser();

    /**
     * 通过 id 删除账户 ;
     *
     * @param userId ;
     * @return ;
     */
    int deleteUserById(int userId);

    /**
     * 更新账户状态
     *
     * @param userStatus ;
     * @param userId     ;
     * @return ;
     */
    int updateUserStatusById(String userStatus, Integer userId);

    /**
     * 更改用户组
     *
     * @param userId  ;
     * @param groupId ;
     * @return ;
     */
    int updateUserGroupById(int userId, int groupId);

    /**
     * 记录总记录数
     *
     * @return ;
     */
    int countUser();

    /**
     * 模糊查询 账户
     *
     * @param val 输入框值 ;
     * @return ;
     */
    List<UserManagerVO> listFuzzyUser(String val);

}
