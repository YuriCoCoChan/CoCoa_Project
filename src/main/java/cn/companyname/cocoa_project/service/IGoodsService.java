package cn.companyname.cocoa_project.service;

import cn.companyname.cocoa_project.model.vo.MainIndexImageVO;

import java.util.List;

/**
 * @author CoCo
 * @date 2021年2月27日02:57:31
 */
public interface IGoodsService {
    /**
     * 查找新商品
     *
     * @return ;
     */
    List<MainIndexImageVO> listNewGoods();

    /**
     * 查找展示商品
     *
     * @return ;
     */
    List<MainIndexImageVO> listArtGoods();

    /**
     * 查找热门商品
     *
     * @return 集合;
     */
    List<MainIndexImageVO> listPopularGoods();

    /**
     * 查找人们商品 (1)
     *
     * @return 对象;
     */
    List<MainIndexImageVO> listGoodsByRecommend();
}
