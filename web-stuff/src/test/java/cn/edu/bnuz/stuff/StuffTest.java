package cn.edu.bnuz.stuff;

import cn.edu.bnuz.domain.stuff.Stuff;
import cn.edu.bnuz.stuff.service.StuffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 文件 StuffTest 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StuffApplication.class)
public class StuffTest {
    @Autowired
    private StuffService stuffService;

    @Test
    public void stuffTest() {
        Stuff stuff = new Stuff("1401030122", "loss",
                "13798968848", "测试上传东西", "[\"123.txt\", \"23.jpg\"]",
                new Date());

        stuffService.insertStuff(stuff);

        System.out.println(stuffService.pageFind("loss", 0));
    }
}
