package cn.edu.bnuz.classroom.entity;

import java.util.Date;

/**
 * 文件 ClassroomApply 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
public class ClassroomApply {
    private int applyId;
    private String number;
    private String day;
    private String time;
    private String classroom;
    private String reason;
    private String status;
    private Date createTime;

    public ClassroomApply() {

    }

    public ClassroomApply(int applyId, String number, String day, String time, String classroom, String reason, String status, Date createTime) {
        this.applyId = applyId;
        this.number = number;
        this.day = day;
        this.time = time;
        this.classroom = classroom;
        this.reason = reason;
        this.status = status;
        this.createTime = createTime;
    }

    public ClassroomApply(String number, String day, String time, String classroom, String reason, String status, Date createTime) {
        this.number = number;
        this.day = day;
        this.time = time;
        this.classroom = classroom;
        this.reason = reason;
        this.status = status;
        this.createTime = createTime;
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
