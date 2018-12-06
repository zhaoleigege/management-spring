package cn.edu.bnuz.stuff.oauth;

import cn.edu.bnuz.oauth.client.ResourceWebSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * 文件 StuffResourceWebSecurity 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class StuffResourceWebSecurity extends ResourceWebSecurity {
}
