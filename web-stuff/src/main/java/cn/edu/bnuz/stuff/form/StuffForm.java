package cn.edu.bnuz.stuff.form;

import java.util.List;

/**
 * 文件 StuffForm 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
public class StuffForm {
    private String type;
    private String phone;
    private String description;
    private List<String> images;

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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
