package cn.companyname.cocoa_project.model.bean;

/**
 * @author CoCo
 * @date 2021年3月8日14:47:05
 */
public class FinalFilePathBean {
    private final static String USER_DEFAULT_TITLE_PATH = "/image/avatar/default.jpg";
    private final static String GOOD_NOT_IMG_PATH = "/image/goods/no_image.png";

    public static String getUserDefualtTitlePath() {
        return USER_DEFAULT_TITLE_PATH;
    }

    public static String getGoodNotImgPath() {
        return GOOD_NOT_IMG_PATH;
    }
}
