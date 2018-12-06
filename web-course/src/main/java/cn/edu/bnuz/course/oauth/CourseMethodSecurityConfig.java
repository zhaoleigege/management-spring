package cn.edu.bnuz.course.oauth;

import cn.edu.bnuz.oauth.client.MethodSecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 文件 StuffMethodSecurityConfig 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CourseMethodSecurityConfig extends MethodSecurityConfiguration {
}
