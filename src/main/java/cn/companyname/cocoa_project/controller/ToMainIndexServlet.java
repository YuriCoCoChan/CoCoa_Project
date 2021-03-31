package cn.companyname.cocoa_project.controller;

import cn.companyname.cocoa_project.model.bean.FinalFilePathBean;
import cn.companyname.cocoa_project.model.vo.MainIndexImageVO;
import cn.companyname.cocoa_project.service.IGoodsService;
import cn.companyname.cocoa_project.service.IProvincialService;
import cn.companyname.cocoa_project.service.impl.GoodsServiceImpl;
import cn.companyname.cocoa_project.service.impl.ProvincialServiceImpl;
import cn.companyname.cocoa_project.utils.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * 请求转发首页
 *
 * @author CoCo
 */
@WebServlet(name = "ToMainIndexServlet", value = "/mainindex")
public class ToMainIndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        //如果账户已登录 直接 级联查询
        if (session != null) {
            IProvincialService service = new ProvincialServiceImpl();
            List provincial = service.listProvincial();
            request.setAttribute("provincial", provincial);
        }

        // 加载所有图片 [商品信息]

        IGoodsService service = new GoodsServiceImpl();
        // 新商品
        List<MainIndexImageVO> newGoods = service.listNewGoods();
        for (MainIndexImageVO newGood : newGoods) {
            if (!FileUtil.isExist(request, newGood.getGoodImgSrc())) {
                newGood.setGoodImgSrc(FinalFilePathBean.getGoodNotImgPath());
            }
        }
        request.setAttribute("newGoods", newGoods);
        // 展示商品
        List<MainIndexImageVO> artGoods = service.listArtGoods();
        for (MainIndexImageVO artGood : artGoods) {
            if (!FileUtil.isExist(request, artGood.getGoodImgSrc())) {
                artGood.setGoodImgSrc(FinalFilePathBean.getGoodNotImgPath());
            }
        }
        request.setAttribute("artGoods", artGoods);
        // 热门商品
        List<MainIndexImageVO> popularGoods = service.listPopularGoods();
        for (MainIndexImageVO popularGood : popularGoods) {
            if (!FileUtil.isExist(request, popularGood.getGoodImgSrc())) {
                popularGood.setGoodImgSrc(FinalFilePathBean.getGoodNotImgPath());
            }
        }
        request.setAttribute("popularGoods", popularGoods);
        // 主页面大轮播图!
        List<MainIndexImageVO> recommends = service.listGoodsByRecommend();
        for (MainIndexImageVO recommend : recommends) {
            if (!FileUtil.isExist(request, recommend.getGoodImgSrc())) {
                recommend.setGoodImgSrc(FinalFilePathBean.getGoodNotImgPath());
            }
        }
        request.setAttribute("recommendGoods", recommends);
        //最后请求转发
        request.getRequestDispatcher("/mainindex.jsp").forward(request, response);
    }
}
