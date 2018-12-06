package cn.edu.bnuz.domain.stuff;

import java.util.Date;

/**
 * 文件 Stuff 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
public class Stuff {
    private int stuffId;
    private String number;
    private String type;
    private String phone;
    private String description;
    private String images;
    private Date createTime;

    public Stuff() {
    }

    public Stuff(int stuffId, String number, String type, String phone, String description, String images, Date createTime) {
        this.stuffId = stuffId;
        this.number = number;
        this.type = type;
        this.phone = phone;
        this.description = description;
        this.images = images;
        this.createTime = createTime;
    }

    public Stuff(String number, String type, String phone, String description, String images, Date createTime) {
        this.number = number;
        this.type = type;
        this.phone = phone;
        this.description = description;
        this.images = images;
        this.createTime = createTime;
    }

    public int getStuffId() {
        return stuffId;
    }

    public void setStuffId(int stuffId) {
        this.stuffId = stuffId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "stuffId=" + stuffId +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", images='" + images + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
