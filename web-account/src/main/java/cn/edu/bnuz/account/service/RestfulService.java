package cn.edu.bnuz.account.service;

import cn.edu.bnuz.domain.wx.WxResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Base64;

/**
 * 文件 OauthService 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
public class RestfulService {
    private static final String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}";
    private static final String APP_ID = "wx782ac637623be979";
    private static final String SECRET = "39126307b16b40741a1be3e18ae35bf4";
    private static final String GRANT_TYPE = "authorization_code";

    private static final String OAUTH2_URL = "http://localhost:8080/oauth/token";
    private static final String CLIENT_ID = "muduo_cloud";
    private static final String CLIENT_SECRET = "wechat";
    private static final String OAUTH2_GRANT_TYPE = "password";

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public RestfulService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<OAuth2AccessToken> oauth2(String number, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Basic " + new String(Base64.getEncoder().encode((CLIENT_ID + ":" + CLIENT_SECRET).getBytes())));

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", OAUTH2_GRANT_TYPE);
        body.add("username", number);
        body.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
        return restTemplate.postForEntity(OAUTH2_URL, request, OAuth2AccessToken.class);
    }

    public WxResponse getOpenid(String code) throws IOException {
        RestTemplate template = new RestTemplate();

        System.out.println("code-> " + code);
        return objectMapper.readValue(template.getForObject(WX_URL, String.class, APP_ID, SECRET,
                code, GRANT_TYPE), WxResponse.class);
    }
}
