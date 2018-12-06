package cn.edu.bnuz.account.web;

import cn.edu.bnuz.account.entity.User;
import cn.edu.bnuz.account.form.UserForm;
import cn.edu.bnuz.account.service.AccountInfoService;
import cn.edu.bnuz.account.service.AccountService;
import cn.edu.bnuz.account.service.RestfulService;
import cn.edu.bnuz.domain.user.Account;
import cn.edu.bnuz.domain.user.Authority;
import cn.edu.bnuz.domain.wx.WxResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;

/**
 * 文件 AccountController 创建于 2018/4/11
 *
 * @author 赵磊
 * @version 1.0
 */
@RestController
public class AccountController {

    private PasswordEncoder passwordEncoder;

    private AccountService accountService;

    private AccountInfoService accountInfoService;

    private RestfulService restfulService;


    public AccountController(PasswordEncoder passwordEncoder, AccountService accountService, AccountInfoService accountInfoService, RestfulService restfulService) {
        this.passwordEncoder = passwordEncoder;
        this.accountService = accountService;
        this.accountInfoService = accountInfoService;
        this.restfulService = restfulService;
    }

    @PostMapping("/session")
    public User token(@RequestBody UserForm userForm) throws IOException {
        User user;
        WxResponse wxResponse = accountService.findOpenid(userForm.getNumber());

        if (wxResponse == null) {
            user = accountService.findUser(userForm.getNumber());

            if (user == null) {
                Account account = accountInfoService.studentInfo(userForm.getNumber(), userForm.getPassword());
                account.setPassword(passwordEncoder.encode(account.getPassword()));
                accountService.insertAccount(account, new Authority(account.getNumber(), Collections.singletonList("student")));

                user = new User(account.getNumber(), account.getName(), account.getIdentity(), account.getLbl_xy(),
                        account.getLbl_xzb(), Collections.singletonList("student"));
            }

            wxResponse = restfulService.getOpenid(userForm.getCode());
            wxResponse.setNumber(user.getNumber());
            accountService.insertOpenid(wxResponse);
        } else {
            user = accountService.findUser(userForm.getNumber());
            wxResponse = restfulService.getOpenid(userForm.getCode());
            accountService.updateSessionKey(wxResponse.getOpenid(), wxResponse.getSession_key());
        }

        ResponseEntity<OAuth2AccessToken> response = restfulService.oauth2(userForm.getNumber(), userForm.getPassword());
        user.setToken("Bearer " + response.getBody());
        return user;

    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("")
    public void add(@RequestBody User user) {
        accountService.insertAccount(
                new Account(user.getNumber(), passwordEncoder.encode(user.getPassword()),
                        user.getName(), user.getIdentity(), user.getLbl_xy(), user.getLbl_xzb()),
                new Authority(user.getNumber(), user.getAuthorities()));
    }
}
