package cn.companyname.cocoa_project;

import cn.companyname.cocoa_project.dao.mybatis.*;
import cn.companyname.cocoa_project.model.po.UserGroupPO;
import cn.companyname.cocoa_project.model.vo.MainIndexImageVO;
import cn.companyname.cocoa_project.model.vo.UserManagerVO;
import cn.companyname.cocoa_project.service.*;
import cn.companyname.cocoa_project.service.impl.*;
import cn.companyname.cocoa_project.utils.MybatisUtil;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author CoCo
 */
public class TestApp {
    @Test
    public void testSelectNewGoods() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IGoodsDao dao = sqlSession.getMapper(IGoodsDao.class);
        List<MainIndexImageVO> list = dao.listNewGoods();
        for (MainIndexImageVO mainIndexImageVO : list) {
            System.out.println(mainIndexImageVO.getGoodName());
        }
    }

    @Test
    public void testSelectArtGoods() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IGoodsDao dao = sqlSession.getMapper(IGoodsDao.class);
        List<MainIndexImageVO> list = dao.listArtGoods();
        for (MainIndexImageVO mainIndexImageVO : list) {
            System.out.println(mainIndexImageVO.getGoodName());
        }
    }

    @Test
    public void testSelectAllUserFor_UserSystem() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        List<UserManagerVO> list = dao.listAllUser();
        for (UserManagerVO userManagerVO : list) {
            System.out.println(userManagerVO);
        }
    }

    @Test
    public void testSelectGroup() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserGroupDao dao = sqlSession.getMapper(IUserGroupDao.class);
        List<UserGroupPO> list = dao.listUsersGroup();
        for (UserGroupPO userGroupPO : list) {
            System.out.println(userGroupPO.getUserGroupName());
        }
    }


    @Test
    public void testDeleteUser() {
        int userId = 33;
        IUserService userService = new UserServiceImpl();
        int result = userService.deleteUserById(userId);
        System.out.println(result);
    }

    @Test
    public void testUpdateStatus() {
        int userId = 9;
        String userStatus = "NORMAL";
        IUserService service = new UserServiceImpl();
        int rs = service.updateUserStatusById(userStatus, userId);
        System.out.println(rs);

    }

    @Test
    public void testUpdateGroup() {
        int userId = 19;
        IUserService service = new UserServiceImpl();
        int rs = service.updateUserGroupById(userId, 2);
        System.out.println(rs);
    }

    @Test
    public void testUserLimit() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        List<UserManagerVO> userList = dao.listAllUser();

        PageInfo<UserManagerVO> pageInfo = new PageInfo<>(userList);
        long total = pageInfo.getTotal();
    }

    @Test
    public void testFuzzyQuery() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IUserDao dao = sqlSession.getMapper(IUserDao.class);
        List<UserManagerVO> userList = dao.listFuzzyUser("co");
        for (UserManagerVO userManagerVO : userList) {
            System.out.println(userManagerVO);
        }
    }
}
