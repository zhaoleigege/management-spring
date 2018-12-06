package cn.edu.bnuz.course.oauth;

import cn.edu.bnuz.oauth.client.Oauth2ResourceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 文件 EquipmentOauth2ResourceConfig 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Configuration
@EnableResourceServer
public class CourseOauth2ResourceConfig extends Oauth2ResourceConfiguration {
    public CourseOauth2ResourceConfig(RedisConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //这里配置需要token验证的资源
        http
                .authorizeRequests()
                .antMatchers("/**").authenticated();
    }
}
