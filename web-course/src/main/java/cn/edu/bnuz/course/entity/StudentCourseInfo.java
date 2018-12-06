package cn.edu.bnuz.course.entity;

/**
 * 文件 StudentCourseInfo 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
public class StudentCourseInfo {
    private String courseName;
    private String classroom;
    private String teacher;
    private String time;

    public StudentCourseInfo() {

    }

    public StudentCourseInfo(String courseName, String classroom, String teacher, String time) {
        this.courseName = courseName;
        this.classroom = classroom;
        this.teacher = teacher;
        this.time = time;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
