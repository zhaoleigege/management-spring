package cn.edu.bnuz.account.service;

import cn.edu.bnuz.account.entity.User;
import cn.edu.bnuz.account.repository.AccountRepository;
import cn.edu.bnuz.domain.user.Account;
import cn.edu.bnuz.domain.user.Authority;
import cn.edu.bnuz.domain.wx.WxResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文件 AccountService 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
@Transactional
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void insertAccount(Account account, Authority authority) {
        accountRepository.insertAccount(account);
        accountRepository.insertAuthority(authority);
    }

    public User findUser(String number) {
        try {
            Account account = accountRepository.findAccount(number);
            Authority authority = accountRepository.findAuthority(number);

            return new User(account.getNumber(), account.getName(), account.getIdentity(),
                    account.getLbl_xy(), account.getLbl_xzb(), authority.getAuthorities());
        } catch (NullPointerException ex) {
            return null;
        }

    }

    public void insertOpenid(WxResponse wxResponse) {
        accountRepository.insertWxopenid(wxResponse);
    }

    public WxResponse findOpenid(String number) {
        try {
            return accountRepository.findWxopenid(number);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public void updateSessionKey(String openid, String sessionKey) {
        accountRepository.updateOpenid(openid, sessionKey);
    }
}
