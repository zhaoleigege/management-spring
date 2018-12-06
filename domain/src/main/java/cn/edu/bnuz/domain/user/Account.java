package cn.edu.bnuz.domain.user;

/**
 * 文件 Account 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
public class Account {
    private String number;
    private String password;
    private String name;
    private String identity;
    private String lbl_xy;
    private String lbl_xzb;

    public Account() {
    }

    public Account(String number, String name, String identity, String lbl_xy, String lbl_xzb) {
        this.number = number;
        this.name = name;
        this.identity = identity;
        this.lbl_xy = lbl_xy;
        this.lbl_xzb = lbl_xzb;
    }

    public Account(String number, String password, String name, String identity, String lbl_xy, String lbl_xzb) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.identity = identity;
        this.lbl_xy = lbl_xy;
        this.lbl_xzb = lbl_xzb;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getLbl_xy() {
        return lbl_xy;
    }

    public void setLbl_xy(String lbl_xy) {
        this.lbl_xy = lbl_xy;
    }

    public String getLbl_xzb() {
        return lbl_xzb;
    }

    public void setLbl_xzb(String lbl_xzb) {
        this.lbl_xzb = lbl_xzb;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", lbl_xy='" + lbl_xy + '\'' +
                ", lbl_xzb='" + lbl_xzb + '\'' +
                '}';
    }
}
