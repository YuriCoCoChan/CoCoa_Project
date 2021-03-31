package cn.companyname.cocoa_project.service.impl;

import cn.companyname.cocoa_project.dao.mybatis.IGoodsDao;
import cn.companyname.cocoa_project.model.vo.MainIndexImageVO;
import cn.companyname.cocoa_project.service.IGoodsService;
import cn.companyname.cocoa_project.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author CoCo
 * @date 2021年2月27日02:59:01
 */
public class GoodsServiceImpl implements IGoodsService {

    @Override
    public List<MainIndexImageVO> listNewGoods() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IGoodsDao dao = sqlSession.getMapper(IGoodsDao.class);
        return dao.listNewGoods();
    }

    @Override
    public List<MainIndexImageVO> listArtGoods() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IGoodsDao dao = sqlSession.getMapper(IGoodsDao.class);
        return dao.listArtGoods();
    }

    @Override
    public List<MainIndexImageVO> listPopularGoods() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IGoodsDao dao = sqlSession.getMapper(IGoodsDao.class);
        return dao.listPopularGoods();
    }

    @Override
    public List<MainIndexImageVO> listGoodsByRecommend() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        IGoodsDao dao = sqlSession.getMapper(IGoodsDao.class);
        return dao.listGoodsByRecommend();
    }
}
