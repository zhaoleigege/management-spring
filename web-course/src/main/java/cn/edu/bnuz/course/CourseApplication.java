package cn.edu.bnuz.course;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 文件 CourseApplication 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@SpringBootApplication
@EnableCaching
public class CourseApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CourseApplication.class)
                .run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CourseApplication.class);
    }
}
