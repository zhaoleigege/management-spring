package cn.edu.bnuz.account.repository;

import cn.edu.bnuz.domain.user.Account;
import cn.edu.bnuz.domain.user.Authority;
import cn.edu.bnuz.domain.wx.WxResponse;
import org.jooq.*;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.*;

import static cn.edu.bnuz.jooq.Tables.ACCOUNT;
import static cn.edu.bnuz.jooq.Tables.AUTHORITY;
import static cn.edu.bnuz.jooq.Tables.SESSION;

/**
 * 文件 AccountRepositoryImpl 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private DSLContext create;


    public AccountRepositoryImpl(DSLContext create) {
        this.create = create;
    }

    @CachePut(value = "account", key = "#account.number")
    @Override
    public void insertAccount(Account account) {
        create.insertInto(ACCOUNT,
                ACCOUNT.NUMBER, ACCOUNT.PASSWORD, ACCOUNT.NAME,
                ACCOUNT.IDENTITY, ACCOUNT.LBL_XY, ACCOUNT.LBL_XZB)
                .values(account.getNumber(), account.getPassword(), account.getName(),
                        account.getIdentity(), account.getLbl_xy(), account.getLbl_xzb())
                .execute();
    }

    @CachePut(value = "authority", key = "#authority.number")
    @Override
    public void insertAuthority(Authority authority) {
        BatchBindStep step = create.batch(create.insertInto(AUTHORITY,
                AUTHORITY.NUMBER, AUTHORITY.AUTHORITY_)
                .values((String) null, null));

        authority.getAuthorities().forEach(
                item -> step.bind(authority.getNumber(), item)
        );

        step.execute();
    }

    @Cacheable(value = "account", key = "#number", unless = "#result == null")
    @Override
    public Account findAccount(String number) {
        return create.selectFrom(ACCOUNT)
                .where(ACCOUNT.NUMBER.eq(number))
                .fetchAny().into(Account.class);
    }

    @Cacheable(value = "authority", key = "#number", unless = "#result == null")
    @Override
    public Authority findAuthority(String number) {
        Result<Record2<String, String>> result = create.select(AUTHORITY.NUMBER, AUTHORITY.AUTHORITY_)
                .from(AUTHORITY)
                .where(AUTHORITY.NUMBER.endsWith(number)).fetch();

        Authority authority = new Authority();
        authority.setNumber(result.get(0).getValue(AUTHORITY.NUMBER));

        List<String> authorities = new ArrayList<>(result.size());
        result.forEach(item -> authorities.add(item.getValue(AUTHORITY.AUTHORITY_)));
        authority.setAuthorities(authorities);

        return authority;
    }

    @Override
    public void insertWxopenid(WxResponse wxResponse) {
        create.insertInto(SESSION,
                SESSION.NUMBER, SESSION.OPENID, SESSION.SESSION_KEY, SESSION.UPDATE_TIME)
                .values(wxResponse.getNumber(), wxResponse.getOpenid(), wxResponse.getSession_key(), new Timestamp(new Date().getTime()))
                .execute();
    }

    @Override
    public WxResponse findWxopenid(String number) {
        return create.selectFrom(SESSION)
                .where(SESSION.NUMBER.eq(number))
                .fetchAny().into(WxResponse.class);
    }

    @Override
    public void updateOpenid(String openId, String sessionKey) {
        create.update(SESSION).set(SESSION.SESSION_KEY, sessionKey)
                .set(SESSION.UPDATE_TIME, new Timestamp(new Date().getTime()))
                .where(SESSION.OPENID.eq(openId)).execute();
    }
}
