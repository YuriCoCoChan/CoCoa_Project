package cn.companyname.cocoa_project.dao.impl;

import cn.companyname.cocoa_project.dao.IUserDao;
import cn.companyname.cocoa_project.model.po.UserPO;
import cn.companyname.cocoa_project.model.vo.LoginVO;
import cn.companyname.cocoa_project.model.vo.MainIndexProfileVO;
import cn.companyname.cocoa_project.utils.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * IUserDao 实现类
 *
 * @author CoCo
 */
public class UserDaoImpl extends BasedaoImpl implements IUserDao {
    @Override
    public Integer insertUser(UserPO userPo) {
        int count = -1;
        String val = userPo.getEmail();
        String key = "user_email";
        if (val == null) {
            key = "user_mobile";
            val = userPo.getMobile();
        }
        String sql = "insert into users(user_name,user_password," + key + ") values(?,?,?)";
        PreparedStatement preparedStatement = JdbcUtil.getPreparedStatement(sql);
        try {
            preparedStatement.setString(1, userPo.getUsername());
            preparedStatement.setString(2, userPo.getPassword());
            preparedStatement.setString(3, val);
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return count;
    }

    @Override
    public Integer countUser(String name) {
        Integer count = -1;
        String sql = "select count(user_name) from users where user_name = ?";
        PreparedStatement preparedStatement = JdbcUtil.getPreparedStatement(sql);
        ResultSet rs = null;
        try {
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close();
        }
        return count;
    }

    @Override
    public LoginVO getUser(String name, String password) {
        String sql = "select user_id,user_name,user_group_id,avatar_img_src from users " +
                "where user_name = ? and user_password = ?";
        PreparedStatement preparedStatement = JdbcUtil.getPreparedStatement(sql);
        ResultSet rs = null;
        try {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                LoginVO loginVo = new LoginVO();
                loginVo.setUserId(rs.getInt("user_id"));
                loginVo.setUsername(rs.getString("user_name"));
                loginVo.setGroupId(rs.getInt("user_group_id"));
                loginVo.setAvatarImgSrc(rs.getString("avatar_img_src"));
                return loginVo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close();
        }
        return null;
    }

    @Override
    public MainIndexProfileVO getUser(Integer id) {
        MainIndexProfileVO profileVo = new MainIndexProfileVO();
        ResultSet rs = null;
        String sql = "select group_name,user_email,user_mobile,user_birth,user_age,user_sex,user_city_id,user_provincial_id\n" +
                "from users\n" +
                "         inner join user_group ug on users.user_group_id = ug.group_id\n" +
                "         where users.user_id = " + id;
        PreparedStatement ps = JdbcUtil.getPreparedStatement(sql);
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                profileVo.setUserGroup(rs.getString("group_name"));
                profileVo.setEmail(rs.getString("user_email"));
                profileVo.setMobile(rs.getString("user_mobile"));
                profileVo.setUserProvincial(rs.getInt("user_provincial_id"));
                profileVo.setUserCity(rs.getInt("user_city_id"));
                profileVo.setUserBirth(rs.getString("user_birth"));
                profileVo.setUserAge(rs.getInt("user_age"));
                profileVo.setUserSex(rs.getInt("user_sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close();
        }
        return profileVo;
    }


    /**
     * @param sql  执行语句
     * @param list 值
     * @return ;
     */
    @Override
    public Integer updateUser(String sql, List list) {
        return super.doUpdates(sql, list);
    }

    @Override
    public Integer updateUser(UserPO userPo) {
        int count = -1;
        String sql = "update users set avatar_img_src = ? where user_id= ? ";
        PreparedStatement preparedStatement = JdbcUtil.getPreparedStatement(sql);
        try {
            preparedStatement.setString(1, userPo.getAvatarImgSrc());
            preparedStatement.setInt(2, userPo.getUserId());
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return count = -1;
        } finally {
            JdbcUtil.close();
        }
        return count;
    }

}
