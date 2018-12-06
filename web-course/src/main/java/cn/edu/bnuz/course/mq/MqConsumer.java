package cn.edu.bnuz.course.mq;

import cn.edu.bnuz.course.entity.StudentCourse;
import cn.edu.bnuz.course.repository.CourseRepository;
import cn.edu.bnuz.domain.course.Kcb;
import cn.edu.bnuz.domain.user.Account;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static cn.edu.bnuz.course.mq.ActiveMqConfig.STUDENT_INFO;

/**
 * 文件 MqConsumer 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
public class MqConsumer {
    private static final String TSS_LOGIN_URL = "http://es.bnuz.edu.cn:8080/jwc/login.do";
    private static final String NUMBER_SIGN = "tssName";
    private static final String PASSWORD_SIGN = "tssPassword";

    private CourseRepository courseRepository;

    public MqConsumer(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @JmsListener(destination = STUDENT_INFO, containerFactory = "scListenerFactory")
    public void receiveFailDelivery(@Payload Account account) throws UnirestException, IOException {
        HttpResponse<String> result = Unirest.post("http://es.bnuz.edu.cn:8080/jwc/api.do?method=getKcb")
                .header("Host", "es.bnuz.edu.cn:8080")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .header("'Accept", "*/*")
                .header("'User-Agent", "BNUProject/2.2.1 (com.cenjiawen.app.BNU; build:14; iOS 11.3.0) Alamofire/4.4.0")
                .header("'Accept-Language", "zh-Hans-CN;q=1.0")
                .body("build=14&timestamp=1524142647029&version=2.2.1")
                .asString();

        String cookie = result.getHeaders().getFirst("Set-Cookie").split("; ")[0];

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("cookie", cookie);

        MultiValueMap<String, String> map;
        map = new LinkedMultiValueMap<>();
        map.add("build", "14");
        map.add("timestamp", String.valueOf(new Date().getTime()));
        map.add("version", "2.2.1");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        restTemplate.exchange(TSS_LOGIN_URL, HttpMethod.POST, request, String.class);

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("cookie", cookie);

        map = new LinkedMultiValueMap<>();
        map.add(NUMBER_SIGN, account.getNumber());
        map.add(PASSWORD_SIGN, account.getPassword());

        request = new HttpEntity<>(map, headers);
        restTemplate.exchange(TSS_LOGIN_URL, HttpMethod.POST, request, String.class);

        result = Unirest.post("http://es.bnuz.edu.cn:8080/jwc/api.do?method=getKcb")
                .header("Host", "es.bnuz.edu.cn:8080")
                .header("Cookie", cookie)
                .header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .header("'Accept", "*/*")
                .header("'User-Agent", "BNUProject/2.2.1 (com.cenjiawen.app.BNU; build:14; iOS 11.3.0) Alamofire/4.4.0")
                .header("'Accept-Language", "zh-Hans-CN;q=1.0")
                .body("build=14&timestamp=1524142647029&version=2.2.1")
                .asString();


        ObjectMapper mapper = new ObjectMapper();
        StudentCourse studentCourse = new StudentCourse(account.getNumber(),
                mapper.readValue(result.getBody(), mapper.getTypeFactory().constructCollectionType(List.class, Kcb.class)));

        courseRepository.insertStudentCourse(studentCourse);
    }
}
