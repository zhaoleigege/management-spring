package cn.edu.bnuz.equipment.form;

import java.util.List;

/**
 * 文件 MaintainForm 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
public class MaintainForm {
    private String classroom;
    private String description;
    private String type;
    private List<String> images;

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
