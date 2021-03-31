package cn.companyname.cocoa_project.model.vo;

/**
 * @author CoCo
 */
public class UserManagerVO {
    private Integer userId;
    private Integer userAge;
    private String userName;
    private String userSex;
    private String userBirth;
    private String userTele;
    private String userEmail;
    private String userGroupName;
    private String userRegisteredDate;
    private String userStatus;
    private String liveCity;
    private String liveProvincial;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserTele() {
        return userTele;
    }

    public void setUserTele(String userTele) {
        this.userTele = userTele;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getUserRegisteredDate() {
        return userRegisteredDate;
    }

    public void setUserRegisteredDate(String userRegisteredDate) {
        this.userRegisteredDate = userRegisteredDate;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public void setLiveCity(String liveCity) {
        this.liveCity = liveCity;
    }

    public String getLiveProvincial() {
        return liveProvincial;
    }

    public void setLiveProvincial(String liveProvincial) {
        this.liveProvincial = liveProvincial;
    }

    @Override
    public String toString() {
        return "UserManagerVO{" +
                "userId=" + userId +
                ", userAge=" + userAge +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userTele='" + userTele + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userGroupName='" + userGroupName + '\'' +
                ", userRegisteredDate='" + userRegisteredDate + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", liveCity='" + liveCity + '\'' +
                ", liveProvincial='" + liveProvincial + '\'' +
                '}';
    }
}
