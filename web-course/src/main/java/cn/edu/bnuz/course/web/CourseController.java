package cn.edu.bnuz.course.web;

import cn.edu.bnuz.course.entity.StudentCourseInfo;
import cn.edu.bnuz.course.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件 CourseController 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@RestController
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("courses")
    public List<StudentCourseInfo> getCourses(Principal principal) {
        return courseService.getStudentCourse(principal.getName()).stream()
                .map(item -> new StudentCourseInfo(item.getKcmc(), item.getLocation(),
                        item.getTeacherName(), item.getSchoolTime()))
                .collect(Collectors.toList());
    }
}
