package cn.edu.bnuz.course.entity;

import cn.edu.bnuz.domain.course.Kcb;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 文件 StudentCourse 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@Document
public class StudentCourse {
    private String number;
    private List<Kcb> kcb;

    public StudentCourse() {

    }

    public StudentCourse(String number, List<Kcb> kcb) {
        this.number = number;
        this.kcb = kcb;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Kcb> getKcb() {
        return kcb;
    }

    public void setKcb(List<Kcb> kcb) {
        this.kcb = kcb;
    }
}
