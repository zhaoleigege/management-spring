package cn.edu.bnuz.account;

import cn.edu.bnuz.account.repository.AccountRepository;
import cn.edu.bnuz.account.service.AccountInfoService;
import cn.edu.bnuz.domain.user.Account;
import cn.edu.bnuz.domain.user.Authority;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * 文件 RepositoryTest 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
public class RepositoryTest {
    @Autowired
    private AccountRepository repository;

    @Test
    public void accountTest() {
        System.out.println(repository.findAccount("asdasdasd") == null);
//        repository.insertAccount(new Account("1401030121", "1401030121", "不知道是谁", "学生", "信息技术学院", "14软件01"));
//        repository.insertAuthority(new Authority("1401030121", new ArrayList() {{
//            add("student");
//        }}));
    }

    @Autowired
    private AccountInfoService infoService;

    //    @Test
    public void htmlParse() {
        System.out.println(infoService.studentInfo("1401030122", "511325199709101112"));
    }
}
