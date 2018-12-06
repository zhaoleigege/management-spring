package cn.edu.bnuz.classroom;

import cn.edu.bnuz.classroom.entity.CrStatus;
import cn.edu.bnuz.classroom.repository.ClassroomBookRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 文件 Classroom 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClassroomApplication.class)
public class Classroom {
    @Autowired
    private ClassroomBookRepository bookRepository;

    private static final String[] times = new String[]{
            "1-2", "3-4", "5-6", "7-8", "9", "10-11", "12-13"
    };

    private static final String[] classrooms = new String[]{
            "木铎楼C103", "木铎楼C104", "木铎楼C105",
            "木铎楼C201", "木铎楼C202", "木铎楼C303",
            "木铎楼C305", "木铎楼C404", "木铎楼C505",
    };

        @Test
    public void classroomStatusAdd() {
        List<CrStatus> crStatusList = new ArrayList<>();
        Random random = new Random();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        for (int i = 0; i < 7; i++) {
            for (String time : times) {
                for (String classroom : classrooms) {
                    crStatusList.add(new CrStatus(format.format(c.getTime()), time, classroom, random.nextBoolean()));
                }
            }

            c.add(Calendar.DATE, 1);
        }

        bookRepository.crStatusInsert(crStatusList);
    }

//    @Test
    public void classroomStatusFind() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(bookRepository.findCrStatus("2018-04-20", "1-2", true)));
    }

    //    @Test
    public void classroomStatusUpdate() throws IOException {
        bookRepository.update("2018-04-20", "1-2", "木铎楼C104", false);
    }
}
