package cn.edu.bnuz.domain.wx;

/**
 * 文件 WxResponse 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
public class WxResponse {
    private String session_key;
    private String openid;
    private String number;
    private String update_time;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
