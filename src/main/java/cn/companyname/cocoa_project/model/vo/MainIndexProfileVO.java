package cn.companyname.cocoa_project.model.vo;

/**
 * 首页更改个人资料
 *
 * @author CoCo
 */
public class MainIndexProfileVO {
    private String userGroup;
    private String email;
    private String mobile;
    private String userBirth;
    private Integer userAge;
    private Integer userSex;
    private Integer userProvincial;
    private Integer userCity;
    public MainIndexProfileVO() {
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getEmail() {
        return email;
    }

    public MainIndexProfileVO(String userGroup, String email, String mobile, String userBirth, Integer userAge, Integer userSex, Integer userProvincial, Integer userCity) {
        this.userGroup = userGroup;
        this.email = email;
        this.mobile = mobile;
        this.userBirth = userBirth;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userProvincial = userProvincial;
        this.userCity = userCity;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserProvincial() {
        return userProvincial;
    }

    public void setUserProvincial(Integer userProvincial) {
        this.userProvincial = userProvincial;
    }

    public Integer getUserCity() {
        return userCity;
    }

    public void setUserCity(Integer userCity) {
        this.userCity = userCity;
    }
}
