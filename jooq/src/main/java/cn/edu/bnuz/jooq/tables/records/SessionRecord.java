/*
 * This file is generated by jOOQ.
*/
package cn.edu.bnuz.jooq.tables.records;


import cn.edu.bnuz.jooq.tables.Session;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SessionRecord extends UpdatableRecordImpl<SessionRecord> implements Record5<String, String, Timestamp, Timestamp, String> {

    private static final long serialVersionUID = 194547248;

    /**
     * Setter for <code>muduo_cloud.session.openid</code>. 用户唯一标识
     */
    public void setOpenid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>muduo_cloud.session.openid</code>. 用户唯一标识
     */
    public String getOpenid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>muduo_cloud.session.session_key</code>. 会话密钥
     */
    public void setSessionKey(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>muduo_cloud.session.session_key</code>. 会话密钥
     */
    public String getSessionKey() {
        return (String) get(1);
    }

    /**
     * Setter for <code>muduo_cloud.session.create_time</code>. 创建时间
     */
    public void setCreateTime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>muduo_cloud.session.create_time</code>. 创建时间
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>muduo_cloud.session.update_time</code>. 上次更新时间
     */
    public void setUpdateTime(Timestamp value) {
        set(3, value);
    }

    /**
     * Getter for <code>muduo_cloud.session.update_time</code>. 上次更新时间
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>muduo_cloud.session.number</code>. 账号
     */
    public void setNumber(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>muduo_cloud.session.number</code>. 账号
     */
    public String getNumber() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, Timestamp, Timestamp, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<String, String, Timestamp, Timestamp, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Session.SESSION.OPENID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Session.SESSION.SESSION_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Session.SESSION.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return Session.SESSION.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Session.SESSION.NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getOpenid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSessionKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component4() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getOpenid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSessionKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionRecord value1(String value) {
        setOpenid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionRecord value2(String value) {
        setSessionKey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionRecord value3(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionRecord value4(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionRecord value5(String value) {
        setNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SessionRecord values(String value1, String value2, Timestamp value3, Timestamp value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SessionRecord
     */
    public SessionRecord() {
        super(Session.SESSION);
    }

    /**
     * Create a detached, initialised SessionRecord
     */
    public SessionRecord(String openid, String sessionKey, Timestamp createTime, Timestamp updateTime, String number) {
        super(Session.SESSION);

        set(0, openid);
        set(1, sessionKey);
        set(2, createTime);
        set(3, updateTime);
        set(4, number);
    }
}
