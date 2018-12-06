package cn.edu.bnuz.domain.course;

/**
 * 文件 XskcbId 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
public class XskcbId {
    private String xn;
    private String xq;
    private String xh;
    private String xkkh;
    private int xqj;
    private int djj;
    private int skcd;
    private String dsz;
    private String qsz;
    private String jsz;

    public String getXn() {
        return xn;
    }

    public void setXn(String xn) {
        this.xn = xn;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXkkh() {
        return xkkh;
    }

    public void setXkkh(String xkkh) {
        this.xkkh = xkkh;
    }

    public int getXqj() {
        return xqj;
    }

    public void setXqj(int xqj) {
        this.xqj = xqj;
    }

    public int getDjj() {
        return djj;
    }

    public void setDjj(int djj) {
        this.djj = djj;
    }

    public int getSkcd() {
        return skcd;
    }

    public void setSkcd(int skcd) {
        this.skcd = skcd;
    }

    public String getDsz() {
        return dsz;
    }

    public void setDsz(String dsz) {
        this.dsz = dsz;
    }

    public String getQsz() {
        return qsz;
    }

    public void setQsz(String qsz) {
        this.qsz = qsz;
    }

    public String getJsz() {
        return jsz;
    }

    public void setJsz(String jsz) {
        this.jsz = jsz;
    }

    @Override
    public String toString() {
        return "XskcbId{" +
                "xn='" + xn + '\'' +
                ", xq='" + xq + '\'' +
                ", xh='" + xh + '\'' +
                ", xkkh='" + xkkh + '\'' +
                ", xqj=" + xqj +
                ", djj=" + djj +
                ", skcd=" + skcd +
                ", dsz='" + dsz + '\'' +
                ", qsz='" + qsz + '\'' +
                ", jsz='" + jsz + '\'' +
                '}';
    }
}
