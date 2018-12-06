package cn.edu.bnuz.classroom.entity;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 文件 CrDay 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@Document(collection = "classroomStatus")
public class CrStatus {
    private String day;
    private String time;
    private String classroom;
    private boolean book;

    public CrStatus() {

    }

    public CrStatus(String day, String time, String classroom, boolean book) {
        this.day = day;
        this.time = time;
        this.classroom = classroom;
        this.book = book;
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

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }
}
