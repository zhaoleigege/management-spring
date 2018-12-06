package cn.edu.bnuz.classroom.repository;

import cn.edu.bnuz.classroom.entity.CrStatus;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文件 ClassroomBookRepository 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@Repository
public class MongoDBClassroomBookRepositoryImpl implements ClassroomBookRepository {
    private MongoTemplate mongoTemplate;

    public MongoDBClassroomBookRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void crStatusInsert(List<CrStatus> crStatusList) {
        mongoTemplate.insertAll(crStatusList);
    }

    @Override
    public List<CrStatus> findCrStatus(String day, String time, boolean book) {
        Query query = new Query();
        query.addCriteria(Criteria
                .where("day").is(day)
                .and("time").is(time)
                .and("book").is(book)
        );
        return mongoTemplate.find(query, CrStatus.class);

    }

    @Override
    public void update(String day, String time, String classroom, boolean book) {
        Query query = new Query();
        query.addCriteria(Criteria
                .where("day").is(day)
                .and("time").is(time)
                .and("classroom").is(classroom)
        );

        Update update = new Update();
        update.set("book", book);

        mongoTemplate.updateFirst(query, update, CrStatus.class);
    }
}
