package cn.edu.bnuz.account.oauth;

import cn.edu.bnuz.oauth.client.Oauth2ResourceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 文件 StuffOauth2ResourceConfig 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Configuration
@EnableResourceServer
public class AccountOauth2ResourceConfig extends Oauth2ResourceConfiguration {
    public AccountOauth2ResourceConfig(RedisConnectionFactory connectionFactory) {
        super(connectionFactory);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //这里配置需要token验证的资源
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/session").permitAll()
                .antMatchers("/**").authenticated();
    }
}
