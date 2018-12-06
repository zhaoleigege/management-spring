package cn.edu.bnuz.domain.equipment;

import java.util.Date;

/**
 * 文件 Equipment 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
public class Maintain {
    private int maintainId;
    private String reportNumber;
    private String repairNumber;
    private String type;
    private String status;
    private String classroom;
    private String description;
    private String images;
    private Date updateTime;

    public Maintain() {

    }

    public Maintain(String reportNumber, String type, String classroom, String description, String images, Date updateTime) {
        this.reportNumber = reportNumber;
        this.type = type;
        this.classroom = classroom;
        this.description = description;
        this.images = images;
        this.updateTime = updateTime;
    }

    public Maintain(int maintainId, String reportNumber, String repairNumber, String type, String status, String classroom, String description, String images, Date updateTime) {
        this.maintainId = maintainId;
        this.reportNumber = reportNumber;
        this.repairNumber = repairNumber;
        this.type = type;
        this.status = status;
        this.classroom = classroom;
        this.description = description;
        this.images = images;
        this.updateTime = updateTime;
    }

    public int getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(int maintainId) {
        this.maintainId = maintainId;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(String repairNumber) {
        this.repairNumber = repairNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
