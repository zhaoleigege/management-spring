package cn.edu.bnuz.domain.course;

/**
 * 文件 Kcb 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
public class Kcb {
    private XskcbId xskcbId;
    private String kcb;
    private String xkcs;
    private String xsf;
    private String kcmc;
    private String teacherName;
    private String schoolTime;
    private String location;

    public XskcbId getXskcbId() {
        return xskcbId;
    }

    public void setXskcbId(XskcbId xskcbId) {
        this.xskcbId = xskcbId;
    }

    public String getKcb() {
        return kcb;
    }

    public void setKcb(String kcb) {
        this.kcb = kcb;
    }

    public String getXkcs() {
        return xkcs;
    }

    public void setXkcs(String xkcs) {
        this.xkcs = xkcs;
    }

    public String getXsf() {
        return xsf;
    }

    public void setXsf(String xsf) {
        this.xsf = xsf;
    }

    public String getKcmc() {
        return kcmc;
    }

    public void setKcmc(String kcmc) {
        this.kcmc = kcmc;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(String schoolTime) {
        this.schoolTime = schoolTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Kcb{" +
                "xskcbId=" + xskcbId +
                ", kcb='" + kcb + '\'' +
                ", xkcs='" + xkcs + '\'' +
                ", xsf='" + xsf + '\'' +
                ", kcmc='" + kcmc + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", schoolTime='" + schoolTime + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
