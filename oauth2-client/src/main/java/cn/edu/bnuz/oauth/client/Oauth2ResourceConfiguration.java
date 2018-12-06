package cn.edu.bnuz.oauth.client;

import cn.edu.bnuz.domain.oauth.CustomRedisTokenStore;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

/**
 * 文件 Oauth2ResourceConfiguration 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */

public class Oauth2ResourceConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "muduo";

    private RedisConnectionFactory connectionFactory;

    public Oauth2ResourceConfiguration(RedisConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID).stateless(false)
                .tokenStore(new CustomRedisTokenStore(connectionFactory));

        OAuth2AuthenticationEntryPoint entryPoint = new OAuth2AuthenticationEntryPoint();

        resources.authenticationEntryPoint(entryPoint);
    }
}
