package cn.companyname.cocoa_project.dao;

import cn.companyname.cocoa_project.model.po.UserPO;
import cn.companyname.cocoa_project.model.vo.LoginVO;
import cn.companyname.cocoa_project.model.vo.MainIndexProfileVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author CoCo
 */
public interface IUserDao {
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
     * 登陆
     *
     * @param name     账户名
     * @param password 密码
     * @return 执行结果
     */
    LoginVO getUser(String name, String password);

    /**
     * 查询个人资料
     *
     * @param id 账户id
     * @return ;
     */
    MainIndexProfileVO getUser(Integer id);

    /**
     * 更新个人资料
     *
     * @param sql  ;
     * @param list ;
     * @return ;
     */
    Integer updateUser(String sql, List list);


    /**
     * 更新头像信息
     *
     * @param userPo ;
     * @return ;
     */
    Integer updateUser(UserPO userPo);
}
