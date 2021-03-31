package cn.companyname.cocoa_project.model.po;

import java.util.Date;

/**
 * Users 表 实体类
 *
 * @author CoCo
 */
public class UserPO {
    private Integer userId;
    private String username;
    private String password;
    private String birthplace;
    private Date birth;
    private int sex;
    private int age;
    private String mobile;
    private String email;
    private Date registerDate;
    private Integer avatarId;
    private Integer groupId;
    private String avatarImgSrc;

    public UserPO() {
    }

    public UserPO(Integer userId, String username, String password, String birthplace, Date birth, int sex, int age, String mobile, String email, Date registerDate, Integer avatarId, Integer groupId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.birthplace = birthplace;
        this.birth = birth;
        this.sex = sex;
        this.age = age;
        this.mobile = mobile;
        this.email = email;
        this.registerDate = registerDate;
        this.avatarId = avatarId;
        this.groupId = groupId;
    }

    public String getAvatarImgSrc() {
        return avatarImgSrc;
    }

    public void setAvatarImgSrc(String avatarImgSrc) {
        this.avatarImgSrc = avatarImgSrc;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", birth=" + birth +
                ", sex=" + sex +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", avatarId=" + avatarId +
                ", groupId=" + groupId +
                '}';
    }
}
