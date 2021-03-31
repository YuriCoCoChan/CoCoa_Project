package cn.companyname.cocoa_project.service;

import cn.companyname.cocoa_project.model.dto.ProfileDTO;
import cn.companyname.cocoa_project.model.po.UserPO;
import cn.companyname.cocoa_project.model.vo.LoginVO;
import cn.companyname.cocoa_project.model.vo.MainIndexProfileVO;
import cn.companyname.cocoa_project.model.vo.UserManagerVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 账户业务层
 *
 * @author CoCo
 */
public interface IUserService {
    /**
     * 注册账户
     *
     * @param userPo 账户表实体类
     * @return 执行结果
     */
    Integer insertUser(UserPO userPo);

    /**
     * 查询是否已存在账户
     *
     * @param name 账户名
     * @return 执行结果
     */
    Integer countUser(String name);

    /**
     * 登录
     *
     * @param name     账户名
     * @param password 密码
     * @param request  ;
     * @return 执行结果
     */
    LoginVO getUser(HttpServletRequest request, String name, String password);

    /**
     * 查询个人资料信息
     *
     * @param id ;
     * @return ;
     */
    MainIndexProfileVO getUser(Integer id);

    /**
     * 更新个人资料
     *
     * @param profileDTO ;
     * @return ;
     */
    Integer updateUser(ProfileDTO profileDTO);

    /**
     * 更新头像
     *
     * @param request ;
     * @return ;
     */
    Integer updateUser(HttpServletRequest request);

    /**
     * 账户系统 查询所有账户
     *
     * @return ;
     */
    List<UserManagerVO> listAllUser();

    /**
     * 通过 主键ID 删除账户
     *
     * @param id ;
     * @return ;
     */
    int deleteUserById(int id);

    /**
     * 通过主键 id 更新 账户状态
     *
     * @param userId     ;
     * @param userStatus ;
     * @return ;
     */
    int updateUserStatusById(String userStatus, int userId);

    /**
     * 更改用户组
     *
     * @param userId  ;
     * @param groupId ;
     * @return ;
     */
    int updateUserGroupById(int userId, int groupId);

    /**
     * 模糊查询账户
     *
     * @param val ;
     * @return ;
     */
    List<UserManagerVO> listFuzzyUser(String val);

}
