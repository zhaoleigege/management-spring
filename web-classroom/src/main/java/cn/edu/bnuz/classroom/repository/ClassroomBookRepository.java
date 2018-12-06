package cn.edu.bnuz.classroom.repository;

import cn.edu.bnuz.classroom.entity.CrStatus;

import java.util.List;

/**
 * 文件 ClassroomBookRepository 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
public interface ClassroomBookRepository {
    void crStatusInsert(List<CrStatus> crStatusList);

    List<CrStatus> findCrStatus(String day, String time, boolean book);

    void update(String day, String time, String classroom, boolean book);
}
