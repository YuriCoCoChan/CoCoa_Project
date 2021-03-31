package cn.companyname.cocoa_project.model.dto;

/**
 * 修改个人资料的数据
 * @author CoCo
 */
public class ProfileDTO {
    private String email;
    private String mobile;
    private String userBirth;
    private Integer userId;
    private Integer provincialId;
    private Integer cityId;
    private Integer age;
    private Integer sex;

    public String getEmail() {
        return email;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProvincialId() {
        return provincialId;
    }

    public void setProvincialId(Integer provincialId) {
        this.provincialId = provincialId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userId=" + userId +
                ", provincialId=" + provincialId +
                ", cityId=" + cityId +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
