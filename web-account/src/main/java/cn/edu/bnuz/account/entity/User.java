package cn.edu.bnuz.account.entity;

import java.util.List;

/**
 * 文件 User 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
public class User {
    private String number;
    private String password;
    private String name;
    private String identity;
    private String lbl_xy;
    private String lbl_xzb;
    private String token;
    private List<String> authorities;

    public User() {
    }

    public User(String number, String name, String identity, String lbl_xy, String lbl_xzb, List<String> authorities) {
        this.number = number;
        this.name = name;
        this.identity = identity;
        this.lbl_xy = lbl_xy;
        this.lbl_xzb = lbl_xzb;
        this.authorities = authorities;
    }

    public User(String number, String password, String name, String identity, String lbl_xy, String lbl_xzb, String token, List<String> authorities) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.identity = identity;
        this.lbl_xy = lbl_xy;
        this.lbl_xzb = lbl_xzb;
        this.token = token;
        this.authorities = authorities;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
