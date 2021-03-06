/*
 * This file is generated by jOOQ.
*/
package cn.edu.bnuz.jooq.tables.records;


import cn.edu.bnuz.jooq.tables.Authority;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class AuthorityRecord extends UpdatableRecordImpl<AuthorityRecord> implements Record2<String, String> {

    private static final long serialVersionUID = 5941587;

    /**
     * Setter for <code>muduo_cloud.authority.number</code>.
     */
    public void setNumber(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>muduo_cloud.authority.number</code>.
     */
    public String getNumber() {
        return (String) get(0);
    }

    /**
     * Setter for <code>muduo_cloud.authority.authority</code>.
     */
    public void setAuthority(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>muduo_cloud.authority.authority</code>.
     */
    public String getAuthority() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Authority.AUTHORITY.NUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Authority.AUTHORITY.AUTHORITY_;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAuthority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getNumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAuthority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorityRecord value1(String value) {
        setNumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorityRecord value2(String value) {
        setAuthority(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthorityRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AuthorityRecord
     */
    public AuthorityRecord() {
        super(Authority.AUTHORITY);
    }

    /**
     * Create a detached, initialised AuthorityRecord
     */
    public AuthorityRecord(String number, String authority) {
        super(Authority.AUTHORITY);

        set(0, number);
        set(1, authority);
    }
}
