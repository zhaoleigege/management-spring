package cn.edu.bnuz.equipment.repository;

import cn.edu.bnuz.domain.equipment.Maintain;
import cn.edu.bnuz.jooq.tables.records.MaintainRecord;
import org.jooq.DSLContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static cn.edu.bnuz.jooq.Tables.MAINTAIN;

/**
 * 文件 MainRepository 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@Repository
public class MainRepository {
    private DSLContext create;

    public MainRepository(DSLContext create) {
        this.create = create;
    }

    private Maintain Record2Maintain(MaintainRecord record) {
        return new Maintain(record.getMaintainId(), record.getReportNumber(), record.getRepairNumber(), record.getType(), record.getStatus(), record.getClassroom(),
                record.getDescription(), record.getImages(), record.getUpdateTime());
    }

    public void insert(Maintain maintain) {
        create.insertInto(MAINTAIN,
                MAINTAIN.REPORT_NUMBER, MAINTAIN.TYPE, MAINTAIN.STATUS, MAINTAIN.CLASSROOM, MAINTAIN.DESCRIPTION, MAINTAIN.IMAGES, MAINTAIN.UPDATE_TIME
        ).values(maintain.getReportNumber(), maintain.getType(), maintain.getStatus(), maintain.getClassroom(), maintain.getDescription(), maintain.getImages(), new Timestamp(maintain.getUpdateTime().getTime()))
                .execute();
    }

    @Cacheable(value = "maintain", key = "#maintainId", unless = "#result == null")
    public Maintain find(int maintainId) {
        MaintainRecord record = create.selectFrom(MAINTAIN)
                .where(MAINTAIN.MAINTAIN_ID.eq(maintainId))
                .fetchAny();

        return Record2Maintain(record);
    }

    @CacheEvict(value = "maintain", key = "#maintainId")
    public void repairUpdate(int maintainId, String repairNumber) {
        create.update(MAINTAIN).set(MAINTAIN.REPAIR_NUMBER, repairNumber)
                .set(MAINTAIN.UPDATE_TIME, new Timestamp(new Date().getTime()))
                .set(MAINTAIN.STATUS, "repaired")
                .where(MAINTAIN.MAINTAIN_ID.eq(maintainId))
                .execute();
    }

    public List<Maintain> reportPageFind(int page) {
        List<Maintain> maintains = new ArrayList<>();

        create.selectFrom(MAINTAIN)
                .where(MAINTAIN.STATUS.eq("repairing"))
                .orderBy(MAINTAIN.UPDATE_TIME.desc().nullsFirst())
                .limit(100)
                .offset(page)
                .forUpdate()
                .fetch().forEach(item -> maintains.add(Record2Maintain(item)));

        return maintains;
    }

    public List<Maintain> repairedPageFind(String repairNumber, int page) {
        List<Maintain> maintains = new ArrayList<>();

        create.selectFrom(MAINTAIN)
                .where(MAINTAIN.STATUS.eq("repaired"))
                .and(MAINTAIN.REPAIR_NUMBER.eq(repairNumber))
                .orderBy(MAINTAIN.UPDATE_TIME.desc().nullsFirst())
                .limit(100)
                .offset(page)
                .forUpdate()
                .fetch().forEach(item -> maintains.add(Record2Maintain(item)));

        return maintains;
    }


}
