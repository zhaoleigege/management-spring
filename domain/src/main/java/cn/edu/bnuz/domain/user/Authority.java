package cn.edu.bnuz.domain.user;

import java.util.List;

/**
 * 文件 Authority 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
public class Authority {
    private String number;
    private List<String> authorities;

    public Authority() {
    }

    public Authority(String number, List<String> authorities) {
        this.number = number;
        this.authorities = authorities;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
