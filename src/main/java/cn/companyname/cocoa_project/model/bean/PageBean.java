package cn.companyname.cocoa_project.model.bean;

/**
 * @author CoCo
 * @date 2021年3月6日12:24:55
 */
public class PageBean {
    /**
     * 现在的页数
     */
    private Integer pageIndex;

    /**
     * 每页显示记录数量
     */
    private Integer pageLimit;

    /**
     * 总数据
     */
    private Integer dataCount;

    private Integer pageCount;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount() {
        /*
         * 获取总页数 [总数据 / 每页记录数]
         * */
        int num = dataCount / pageLimit;
        pageCount = dataCount % pageLimit;
        this.pageCount = pageCount == 0 ? num : num + 1;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageLimit() {
        return pageLimit;
    }

    public void setPageLimit(Integer pageLimit) {
        this.pageLimit = pageLimit;
    }
}
