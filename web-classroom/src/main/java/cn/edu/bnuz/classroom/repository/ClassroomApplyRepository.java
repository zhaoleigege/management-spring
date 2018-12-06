package cn.edu.bnuz.classroom.repository;

import cn.edu.bnuz.classroom.entity.ClassroomApply;
import cn.edu.bnuz.jooq.tables.records.ClassroomApplyRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static cn.edu.bnuz.jooq.Tables.CLASSROOM_APPLY;
import static org.jooq.impl.DSL.trueCondition;

/**
 * 文件 ClassroomApplyRepository 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@Repository
public class ClassroomApplyRepository {
    private DSLContext create;

    public ClassroomApplyRepository(DSLContext create) {
        this.create = create;
    }

    private ClassroomApply record2ClassroomApply(ClassroomApplyRecord record) {
        return new ClassroomApply(record.getId(), record.getNumber(), record.getDay(), record.getTime(), record.getClassroom(),
                record.getReason(), record.getStatus(), record.getCreateTime());
    }

    public void addClassroomApply(ClassroomApply apply) {
        create.insertInto(CLASSROOM_APPLY,
                CLASSROOM_APPLY.NUMBER, CLASSROOM_APPLY.DAY, CLASSROOM_APPLY.TIME, CLASSROOM_APPLY.CLASSROOM,
                CLASSROOM_APPLY.REASON, CLASSROOM_APPLY.STATUS, CLASSROOM_APPLY.CREATE_TIME
        ).values(apply.getNumber(), apply.getDay(), apply.getTime(), apply.getClassroom(),
                apply.getReason(), apply.getStatus(), new Timestamp(apply.getCreateTime().getTime()))
                .execute();
    }

    public ClassroomApply find(int applyId) {
        return record2ClassroomApply(create.selectFrom(CLASSROOM_APPLY)
                .where(CLASSROOM_APPLY.ID.eq(applyId))
                .fetchAny());
    }

    public List<ClassroomApply> pageFind(String number, String status, int page) {
        Condition condition = trueCondition();

        if (number != null)
            condition = condition.and(CLASSROOM_APPLY.NUMBER.eq(number));

        if (status != null)
            condition = condition.and(CLASSROOM_APPLY.STATUS.eq(status));


        Result<ClassroomApplyRecord> records = create.selectFrom(CLASSROOM_APPLY)
                .where(condition)
                .orderBy(CLASSROOM_APPLY.CREATE_TIME.desc().nullsFirst())
                .limit(100)
                .offset(page)
                .forUpdate()
                .fetch();

        return records.stream().map(this::record2ClassroomApply).collect(Collectors.toList());
    }

    public void updateApply(int applyId, String status) {
        create.update(CLASSROOM_APPLY).set(CLASSROOM_APPLY.STATUS, status)
                .where(CLASSROOM_APPLY.ID.eq(applyId))
                .execute();
    }
}
