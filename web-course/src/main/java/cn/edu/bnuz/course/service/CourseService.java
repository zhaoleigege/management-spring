package cn.edu.bnuz.course.service;

import cn.edu.bnuz.course.repository.CourseRepository;
import cn.edu.bnuz.domain.course.Kcb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件 CourseService 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
@Transactional
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Kcb> getStudentCourse(String number) {
        return courseRepository.findStudentCourse(number);
    }
}
