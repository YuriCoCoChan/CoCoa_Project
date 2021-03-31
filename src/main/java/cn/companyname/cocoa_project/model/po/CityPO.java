package cn.companyname.cocoa_project.model.po;

/**
 * @author CoCo
 */
public class CityPO {
    private Integer cityId;
    private String cityName;

    public CityPO() {
    }

    public CityPO(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
