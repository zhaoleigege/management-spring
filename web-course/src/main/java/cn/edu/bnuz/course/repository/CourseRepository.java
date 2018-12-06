package cn.edu.bnuz.course.repository;

import cn.edu.bnuz.course.entity.StudentCourse;
import cn.edu.bnuz.domain.course.Kcb;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文件 CourseRepository 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@Repository
public class CourseRepository {

    private MongoTemplate mongoTemplate;

    public CourseRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void insertStudentCourse(StudentCourse studentCourse) {
        mongoTemplate.insert(studentCourse);
    }

    public List<Kcb> findStudentCourse(String number) {
        Query query = new Query();
        query.addCriteria(Criteria
                .where("number").is(number)
        );
        return mongoTemplate.findOne(query, StudentCourse.class).getKcb();
    }
}
