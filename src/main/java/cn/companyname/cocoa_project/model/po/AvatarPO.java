package cn.companyname.cocoa_project.model.po;

/**
 * 头像表
 *
 * @author CoCo
 * @date 2021/1/13
 */
public class AvatarPO {
    private Integer avatarId;
    private String avatarImgSrc;
    private Integer userId;

    @Override
    public String toString() {
        return "AvatarPO{" +
                "avatarId=" + avatarId +
                ", avatarImgSrc='" + avatarImgSrc + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
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

    public AvatarPO(Integer avatarId, String avatarImgSrc, Integer userId) {
        this.avatarId = avatarId;
        this.avatarImgSrc = avatarImgSrc;
        this.userId = userId;
    }

    public AvatarPO() {
    }
}
