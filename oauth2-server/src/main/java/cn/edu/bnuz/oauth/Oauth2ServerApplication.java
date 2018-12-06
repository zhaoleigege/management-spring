package cn.edu.bnuz.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 文件 Oauth2ServerApplication 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@SpringBootApplication
public class Oauth2ServerApplication extends SpringBootServletInitializer {
    private static Class<Oauth2ServerApplication> clazz = Oauth2ServerApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(clazz, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(clazz);
    }
}
