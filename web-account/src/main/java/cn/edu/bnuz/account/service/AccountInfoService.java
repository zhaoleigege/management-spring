package cn.edu.bnuz.account.service;

import cn.edu.bnuz.account.mq.MqProducer;
import cn.edu.bnuz.domain.user.Account;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

/**
 * 文件 AccountInfoService 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
public class AccountInfoService {
    private RestTemplate restTemplate;

    private MqProducer producer;

    public AccountInfoService(RestTemplate restTemplate, MqProducer producer) {
        this.restTemplate = restTemplate;
        this.producer = producer;
    }

    private static final String PERSON_INFO_BASE_URL = "http://es.bnuz.edu.cn/jwgl/xsgrxx.aspx?xh={xh}&xm={xm}&gnmkdm={gnmkdm}";
    private static final String PERSON_INFO_URL = "http://es.bnuz.edu.cn/xs_main.aspx?xh={xh}";
    private static final String TSS_LOGIN_URL = "http://es.bnuz.edu.cn/default2.aspx";
    private static final String NUMBER_SIGN = "TextBox1";
    private static final String PASSWORD_SIGN = "TextBox2";

    //  获得教务网的cookie
    private String getCookie(String userNUmber, String password, String identity) {
        ResponseEntity<String> response = restTemplate.getForEntity("http://es.bnuz.edu.cn/", String.class);
        Document document = Jsoup.parse(response.getBody());
        String __VIEWSTATE = document.select("#__VIEWSTATE").attr("value");
        String __VIEWSTATEGENERATOR = document.select("#__VIEWSTATEGENERATOR").attr("value");
        String __PREVIOUSPAGE = document.select("#__PREVIOUSPAGE").attr("value");
        String __EVENTVALIDATION = document.select("#__EVENTVALIDATION").attr("value");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add(NUMBER_SIGN, userNUmber);
        map.add(PASSWORD_SIGN, password);
        map.add("__EVENTTARGET", "");
        map.add("__EVENTARGUMENT", "");
        map.add("__VIEWSTATE", __VIEWSTATE);
        map.add("__EVENTTARGET", __VIEWSTATEGENERATOR);
        map.add("__PREVIOUSPAGE", __PREVIOUSPAGE);
        map.add("__EVENTVALIDATION", __EVENTVALIDATION);
        map.add("RadioButtonList1", identity);
        map.add("Button4_test", "");


        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        response = restTemplate.exchange(TSS_LOGIN_URL, HttpMethod.POST, request, String.class);
        return response.getHeaders().get("Set-Cookie").stream().collect(Collectors.joining(";"));
    }

    //  打开教务网的主页
    private ResponseEntity<String> getMainPage(String cookie, String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", cookie);

        return restTemplate.exchange(PERSON_INFO_URL, HttpMethod.GET, new HttpEntity<>(headers), String.class, username);

    }

    //  获得用户的信息
    private ResponseEntity<String> sessionAccess(String cookie, String xh, String xm) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", cookie);

        return restTemplate.exchange(PERSON_INFO_BASE_URL, HttpMethod.GET, new HttpEntity<>(headers), String.class, xh, xm, "N121501");
    }


    public Account studentInfo(String number, String password) {
        try {
            String cookie = getCookie(number, password, "学生");
            ResponseEntity<String> response = getMainPage(cookie, number);

            String[] text = Jsoup.parse(response.getBody()).select("#xhxm").text().split(" +");

            response = sessionAccess(cookie, text[0], text[1].substring(0, text[1].length() - 2));

            Document document = Jsoup.parse(response.getBody());

            Account account = new Account(
                    document.select("#xh").text(),
                    password,
                    document.select("#xm").text(),
                    "学生",
                    document.select("#lbl_xy").text(),
                    document.select("#lbl_xzb").text()
            );
            producer.lookupSc(account);

            return account;
        } catch (Exception ex) {
            throw new IllegalArgumentException("信息验证错误");
        }

    }

    public Account teacherInfo(String number, String password) {
        return new Account(
                number,
                password,
                "",
                "老师",
                "信息技术学院",
                ""
        );
    }
}
