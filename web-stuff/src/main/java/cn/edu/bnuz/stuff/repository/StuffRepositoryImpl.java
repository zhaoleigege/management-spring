package cn.edu.bnuz.stuff.repository;

import cn.edu.bnuz.domain.stuff.Stuff;
import cn.edu.bnuz.jooq.tables.records.StuffRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static cn.edu.bnuz.jooq.Tables.STUFF;

/**
 * 文件 StuffRepositoryImpl 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Repository
public class StuffRepositoryImpl implements StuffRepository {
    private DSLContext create;

    public StuffRepositoryImpl(DSLContext create) {
        this.create = create;
    }

    private Stuff record2Stuff(StuffRecord stuffRecord) {
        return new Stuff(stuffRecord.getStuffId(), stuffRecord.getNumber(), stuffRecord.getType(),
                stuffRecord.getPhone(), stuffRecord.getDescription(), stuffRecord.getImages(), stuffRecord.getCreateTime());
    }

    @Override
    public void insert(Stuff stuff) {
        create.insertInto(STUFF,
                STUFF.NUMBER, STUFF.TYPE, STUFF.PHONE, STUFF.DESCRIPTION, STUFF.IMAGES, STUFF.CREATE_TIME)
                .values(stuff.getNumber(), stuff.getType(), stuff.getPhone(), stuff.getDescription(),
                        stuff.getImages(), new Timestamp(stuff.getCreateTime().getTime()))
                .execute();
    }

    @Cacheable(value = "stuff", key = "#stuffId", unless = "#result == null")
    @Override
    public Stuff find(int stuffId) {
        StuffRecord stuffRecord = create.selectFrom(STUFF)
                .where(STUFF.STUFF_ID.eq(stuffId))
                .fetchAny();

        return record2Stuff(stuffRecord);
    }

    @Override
    public List<Stuff> pageFind(String type, int page) {
        Result<StuffRecord> stuffRecords = create.selectFrom(STUFF)
                .where(STUFF.TYPE.eq(type))
                .orderBy(STUFF.CREATE_TIME.desc().nullsFirst())
                .limit(10)
                .offset(page)
                .forUpdate()
                .fetch();

        List<Stuff> stuffs = new ArrayList<>(stuffRecords.size());
        stuffRecords.forEach(stuffRecord -> stuffs.add(record2Stuff(stuffRecord)));

        return stuffs;
    }


}
