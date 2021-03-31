package cn.companyname.cocoa_project.service.impl;

import cn.companyname.cocoa_project.dao.IUserDao;
import cn.companyname.cocoa_project.dao.impl.UserDaoImpl;
import cn.companyname.cocoa_project.model.bean.FinalFilePathBean;
import cn.companyname.cocoa_project.model.dto.ProfileDTO;
import cn.companyname.cocoa_project.model.po.UserPO;
import cn.companyname.cocoa_project.model.vo.LoginVO;
import cn.companyname.cocoa_project.model.vo.UserManagerVO;
import cn.companyname.cocoa_project.service.*;
import cn.companyname.cocoa_project.model.vo.MainIndexProfileVO;
import cn.companyname.cocoa_project.utils.FileUtil;
import cn.companyname.cocoa_project.utils.GetTimeUtil;
import cn.companyname.cocoa_project.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CoCo
 */
public class UserServiceImpl implements IUserService {

    private IUserDao dao;

    public UserServiceImpl() {
        dao = new UserDaoImpl();
    }


    @Override
    public Integer insertUser(UserPO userPo) {
        if (countUser(userPo.getUsername()) == 1) {
            return 0;
        } else {
            return dao.insertUser(userPo);
        }
    }

    @Override
    public Integer countUser(String name) {
        return dao.countUser(name);
    }

    @Override
    public LoginVO getUser(HttpServletRequest request, String name, String password) {
        LoginVO loginVO = dao.getUser(name, password);
        if (!FileUtil.isExist(request, loginVO.getAvatarImgSrc())) {
            loginVO.setAvatarImgSrc(FinalFilePathBean.getUserDefualtTitlePath());
        }
        return loginVO;
    }

    @Override
    public MainIndexProfileVO getUser(Integer id) {
        MainIndexProfileVO profileVO = dao.getUser(id);
        return profileVO;
    }

    /**
     * 修改个人资料
     *
     * @param profileDTO ;
     * @return ;
     */
    @Override
    public Integer updateUser(ProfileDTO profileDTO) {
        List list = new ArrayList();
        String sql = null;
        String dateFormat = "yyyy";
        String date = GetTimeUtil.getBySystem(dateFormat);
        String line = "-";
        list.add(profileDTO.getProvincialId());
        list.add(profileDTO.getCityId());
        list.add(profileDTO.getSex());
        //        全部都有填的话
        if (!profileDTO.getUserBirth().split(line)[0].equals(date) && !"".equals(profileDTO.getMobile()) && !"".equals(profileDTO.getEmail())) {
            sql = "UPDATE users SET user_provincial_id = ?, user_city_id = ?,user_sex = ?, user_mobile = ?, user_email = ?,user_birth = ? ,user_age = ? WHERE `user_id` = ?";
            System.out.println("执行全");
            list.add(profileDTO.getMobile());
            list.add(profileDTO.getEmail());
            list.add(profileDTO.getUserBirth());
            list.add(profileDTO.getAge());
        } else if (!profileDTO.getUserBirth().split(line)[0].equals(date) && !"".equals(profileDTO.getMobile()) && "".equals(profileDTO.getEmail())) {
            sql = "UPDATE users SET user_provincial_id = ?, user_city_id = ?,user_sex = ?, user_mobile = ?,user_birth = ?,user_age = ? WHERE `user_id` = ?";
            System.out.println("只更新了电话和生日");
            list.add(profileDTO.getMobile());
            list.add(profileDTO.getUserBirth());
            list.add(profileDTO.getAge());
        } else if (!profileDTO.getUserBirth().split(line)[0].equals(date) && "".equals(profileDTO.getMobile()) && !"".equals(profileDTO.getEmail())) {
            sql = "UPDATE users SET user_provincial_id = ?, user_city_id = ?,user_sex = ?, user_email = ?,user_birth = ?,user_age = ? WHERE `user_id` = ?";
            System.out.println("只更新了邮箱和生日");
            list.add(profileDTO.getEmail());
            list.add(profileDTO.getUserBirth());
            list.add(profileDTO.getAge());
        } else if (profileDTO.getUserBirth().split(line)[0].equals(date) && "".equals(profileDTO.getMobile()) && !"".equals(profileDTO.getEmail())) {
            sql = "UPDATE users SET user_provincial_id = ?, user_city_id = ?,user_sex = ?, user_email = ?  WHERE `user_id` = ?";
            list.add(profileDTO.getEmail());
            System.out.println("只更新了邮箱");
        } else if (profileDTO.getUserBirth().split(line)[0].equals(date) && !"".equals(profileDTO.getMobile()) && "".equals(profileDTO.getEmail())) {
            sql = "UPDATE users SET user_provincial_id = ?, user_city_id = ?,user_sex = ?, user_mobile = ? WHERE `user_id` = ?";
            list.add(profileDTO.getMobile());
            System.out.println("只更新了电话");
        } else if (profileDTO.getUserBirth().split(line)[0].equals(date) && !"".equals(profileDTO.getMobile()) && !"".equals(profileDTO.getEmail())) {
            sql = "UPDATE users SET user_provincial_id = ?, user_city_id = ?,user_sex = ?, user_mobile = ?, user_email = ? WHERE `user_id` = ?";
            list.add(profileDTO.getMobile());
            list.add(profileDTO.getEmail());
            System.out.println("只更新了电话和邮箱");
        }
        list.add(profileDTO.getUserId());
        return dao.updateUser(sql, list);
    }

    /**
     * 更新头像
     *
     * @param request ;
     * @return ;
     */
    @Override
    public Integer updateUser(HttpServletRequest request) {
        UserPO po = new UserPO();
        HttpSession session = request.getSession(false);
        Integer userId = (Integer) session.getAttribute("userid");
        // 老头像路径
        String oldPath = (String) session.getAttribute("titlesrc");
        //服务器根目录
        String dir = "/image/avatar/";
        String[] date = GetTimeUtil.getByUrl(true);
        String year = date[date.length - 1];
        String month = date[1];
        String dateFormat = "yyyyMMddHHmmss";
        String defaultImg = "default.jpg";
        //删除文件
        System.out.println(oldPath.substring(oldPath.lastIndexOf('/') + 1, oldPath.length()));
        if (!defaultImg.equals(oldPath.substring(oldPath.lastIndexOf('/') + 1, oldPath.length()))) {
            System.out.println("删除文件");
            FileUtil.deleteFile(request.getServletContext().getRealPath(oldPath));
        }
        //文件名
        String fileName = GetTimeUtil.getBySystem(dateFormat) + "_" + userId.toString() + ".jpg";
        //数据库的 新的地址值
        String sqlUploadPath = dir + year + "/" + month + "/" + fileName;
        //服务器的 地址值 [] 绝对路径
        String realUploadPath = request.getServletContext().getRealPath(dir + year + "/" + month);
        //创建文件夹
        FileUtil.createDire(realUploadPath);
        po.setAvatarImgSrc(sqlUploadPath);
        po.setUserId(userId);
        //前台表项值
        String partName = "pictureFile";
        //是否已上传成功
        Boolean isUpload = FileUtil.partFileUpload(request, partName, sqlUploadPath);
        if (isUpload) {
            session.setAttribute("titlesrc", sqlUploadPath);
            return dao.updateUser(po);
        } else {
            return -1;
        }
    }

    @Override
    public List<UserManagerVO> listAllUser() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        cn.companyname.cocoa_project.dao.mybatis.IUserDao userDao = sqlSession.getMapper(cn.companyname.cocoa_project.dao.mybatis.IUserDao.class);
        return userDao.listAllUser();
    }

    @Override
    public int deleteUserById(int id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        cn.companyname.cocoa_project.dao.mybatis.IUserDao dao = sqlSession.getMapper(cn.companyname.cocoa_project.dao.mybatis.IUserDao.class);
        int result = dao.deleteUserById(id);
        return result;
    }

    @Override
    public int updateUserStatusById(String userStatus, int userId) {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        cn.companyname.cocoa_project.dao.mybatis.IUserDao dao = sqlSession.getMapper(cn.companyname.cocoa_project.dao.mybatis.IUserDao.class);
        return dao.updateUserStatusById(userStatus, userId);
    }

    @Override
    public int updateUserGroupById(int userId, int groupId) {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        cn.companyname.cocoa_project.dao.mybatis.IUserDao dao = sqlSession.getMapper(cn.companyname.cocoa_project.dao.mybatis.IUserDao.class);
        return dao.updateUserGroupById(userId, groupId);
    }

    /**
     * 模糊查询账户
     *
     * @param val ;
     * @return ;
     */
    @Override
    public List<UserManagerVO> listFuzzyUser(String val) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        cn.companyname.cocoa_project.dao.mybatis.IUserDao dao = sqlSession.getMapper(cn.companyname.cocoa_project.dao.mybatis.IUserDao.class);
        return dao.listFuzzyUser(val);
    }
}
