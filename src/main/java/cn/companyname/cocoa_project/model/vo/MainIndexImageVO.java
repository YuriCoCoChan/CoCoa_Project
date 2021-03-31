package cn.companyname.cocoa_project.model.vo;

/**
 * 主页面的一个数据显示
 *
 * @author CoCo
 * @date 2021年2月27日02:57:47
 */
public class MainIndexImageVO {
    private Integer goodId;
    private String goodImgSrc;
    private String goodName;
    private String goodDescription;
    private Float goodPrice;

    @Override
    public String toString() {
        return "MainIndexImageVO{" +
                "goodId=" + goodId +
                ", goodImgSrc='" + goodImgSrc + '\'' +
                ", goodName='" + goodName + '\'' +
                ", goodDescription='" + goodDescription + '\'' +
                ", goodPrice=" + goodPrice +
                '}';
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodImgSrc() {
        return goodImgSrc;
    }

    public void setGoodImgSrc(String goodImgSrc) {
        this.goodImgSrc = goodImgSrc;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Float getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Float goodPrice) {
        this.goodPrice = goodPrice;
    }
}
