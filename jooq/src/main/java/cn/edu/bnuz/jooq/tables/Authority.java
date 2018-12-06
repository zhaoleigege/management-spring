/*
 * This file is generated by jOOQ.
*/
package cn.edu.bnuz.jooq.tables;


import cn.edu.bnuz.jooq.Indexes;
import cn.edu.bnuz.jooq.Keys;
import cn.edu.bnuz.jooq.MuduoCloud;
import cn.edu.bnuz.jooq.tables.records.AuthorityRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Authority extends TableImpl<AuthorityRecord> {

    private static final long serialVersionUID = -1630031952;

    /**
     * The reference instance of <code>muduo_cloud.authority</code>
     */
    public static final Authority AUTHORITY = new Authority();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorityRecord> getRecordType() {
        return AuthorityRecord.class;
    }

    /**
     * The column <code>muduo_cloud.authority.number</code>.
     */
    public final TableField<AuthorityRecord, String> NUMBER = createField("number", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "");

    /**
     * The column <code>muduo_cloud.authority.authority</code>.
     */
    public final TableField<AuthorityRecord, String> AUTHORITY_ = createField("authority", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * Create a <code>muduo_cloud.authority</code> table reference
     */
    public Authority() {
        this(DSL.name("authority"), null);
    }

    /**
     * Create an aliased <code>muduo_cloud.authority</code> table reference
     */
    public Authority(String alias) {
        this(DSL.name(alias), AUTHORITY);
    }

    /**
     * Create an aliased <code>muduo_cloud.authority</code> table reference
     */
    public Authority(Name alias) {
        this(alias, AUTHORITY);
    }

    private Authority(Name alias, Table<AuthorityRecord> aliased) {
        this(alias, aliased, null);
    }

    private Authority(Name alias, Table<AuthorityRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return MuduoCloud.MUDUO_CLOUD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.AUTHORITY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AuthorityRecord> getPrimaryKey() {
        return Keys.KEY_AUTHORITY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AuthorityRecord>> getKeys() {
        return Arrays.<UniqueKey<AuthorityRecord>>asList(Keys.KEY_AUTHORITY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authority as(String alias) {
        return new Authority(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authority as(Name alias) {
        return new Authority(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Authority rename(String name) {
        return new Authority(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Authority rename(Name name) {
        return new Authority(name, null);
    }
}