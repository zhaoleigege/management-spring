/*
 * This file is generated by jOOQ.
*/
package cn.edu.bnuz.jooq.tables;


import cn.edu.bnuz.jooq.Indexes;
import cn.edu.bnuz.jooq.Keys;
import cn.edu.bnuz.jooq.MuduoCloud;
import cn.edu.bnuz.jooq.tables.records.ClassroomApplyRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
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
public class ClassroomApply extends TableImpl<ClassroomApplyRecord> {

    private static final long serialVersionUID = 2132138772;

    /**
     * The reference instance of <code>muduo_cloud.classroom_apply</code>
     */
    public static final ClassroomApply CLASSROOM_APPLY = new ClassroomApply();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClassroomApplyRecord> getRecordType() {
        return ClassroomApplyRecord.class;
    }

    /**
     * The column <code>muduo_cloud.classroom_apply.id</code>. 教室申请表Id
     */
    public final TableField<ClassroomApplyRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "教室申请表Id");

    /**
     * The column <code>muduo_cloud.classroom_apply.number</code>. 申请人
     */
    public final TableField<ClassroomApplyRecord, String> NUMBER = createField("number", org.jooq.impl.SQLDataType.VARCHAR(20).nullable(false), this, "申请人");

    /**
     * The column <code>muduo_cloud.classroom_apply.day</code>. 申请的那一天
     */
    public final TableField<ClassroomApplyRecord, String> DAY = createField("day", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "申请的那一天");

    /**
     * The column <code>muduo_cloud.classroom_apply.time</code>. 申请的那几节课
     */
    public final TableField<ClassroomApplyRecord, String> TIME = createField("time", org.jooq.impl.SQLDataType.VARCHAR(5).nullable(false), this, "申请的那几节课");

    /**
     * The column <code>muduo_cloud.classroom_apply.classroom</code>. 申请的哪间教室
     */
    public final TableField<ClassroomApplyRecord, String> CLASSROOM = createField("classroom", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "申请的哪间教室");

    /**
     * The column <code>muduo_cloud.classroom_apply.reason</code>. 申请的原因
     */
    public final TableField<ClassroomApplyRecord, String> REASON = createField("reason", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "申请的原因");

    /**
     * The column <code>muduo_cloud.classroom_apply.status</code>. 申请单的状态(applying-&gt;申请中, applied-&gt;已统一,refuse-&gt;拒绝)
     */
    public final TableField<ClassroomApplyRecord, String> STATUS = createField("status", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "申请单的状态(applying->申请中, applied->已统一,refuse->拒绝)");

    /**
     * The column <code>muduo_cloud.classroom_apply.create_time</code>. 申请的时间
     */
    public final TableField<ClassroomApplyRecord, Timestamp> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "申请的时间");

    /**
     * Create a <code>muduo_cloud.classroom_apply</code> table reference
     */
    public ClassroomApply() {
        this(DSL.name("classroom_apply"), null);
    }

    /**
     * Create an aliased <code>muduo_cloud.classroom_apply</code> table reference
     */
    public ClassroomApply(String alias) {
        this(DSL.name(alias), CLASSROOM_APPLY);
    }

    /**
     * Create an aliased <code>muduo_cloud.classroom_apply</code> table reference
     */
    public ClassroomApply(Name alias) {
        this(alias, CLASSROOM_APPLY);
    }

    private ClassroomApply(Name alias, Table<ClassroomApplyRecord> aliased) {
        this(alias, aliased, null);
    }

    private ClassroomApply(Name alias, Table<ClassroomApplyRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CLASSROOM_APPLY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ClassroomApplyRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CLASSROOM_APPLY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ClassroomApplyRecord> getPrimaryKey() {
        return Keys.KEY_CLASSROOM_APPLY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ClassroomApplyRecord>> getKeys() {
        return Arrays.<UniqueKey<ClassroomApplyRecord>>asList(Keys.KEY_CLASSROOM_APPLY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassroomApply as(String alias) {
        return new ClassroomApply(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClassroomApply as(Name alias) {
        return new ClassroomApply(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ClassroomApply rename(String name) {
        return new ClassroomApply(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ClassroomApply rename(Name name) {
        return new ClassroomApply(name, null);
    }
}
