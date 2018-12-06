package cn.edu.bnuz.account.repository;

import cn.edu.bnuz.domain.user.Account;
import cn.edu.bnuz.domain.user.Authority;
import cn.edu.bnuz.domain.wx.WxResponse;

/**
 * 文件 AccountRepository 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */

public interface AccountRepository {
    void insertAccount(Account account);

    void insertAuthority(Authority authority);

    Account findAccount(String number);

    Authority findAuthority(String number);

    void insertWxopenid(WxResponse wxResponse);

    WxResponse findWxopenid(String number);

    void updateOpenid(String openId, String sessionKey);
}
