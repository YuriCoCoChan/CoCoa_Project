package cn.companyname.cocoa_project.model.vo;

/**
 * Login 页面 传输必要数据
 * @author CoCo
 */
public class LoginVO {
    private Integer userId;
    private String username;
    private Integer groupId;
    private String avatarImgSrc;

    public LoginVO() {
    }

    public LoginVO(Integer userId, String username, Integer groupId, String avatarImgSrc) {
        this.userId = userId;
        this.username = username;
        this.groupId = groupId;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getAvatarImgSrc() {
        return avatarImgSrc;
    }

    public void setAvatarImgSrc(String avatarImgSrc) {
        this.avatarImgSrc = avatarImgSrc;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", groupId=" + groupId +
                ", avatarImgSrc='" + avatarImgSrc + '\'' +
                '}';
    }
}
