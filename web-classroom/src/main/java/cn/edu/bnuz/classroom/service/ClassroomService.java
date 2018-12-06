package cn.edu.bnuz.classroom.service;

import cn.edu.bnuz.classroom.entity.ClassroomApply;
import cn.edu.bnuz.classroom.entity.CrStatus;
import cn.edu.bnuz.classroom.repository.ClassroomApplyRepository;
import cn.edu.bnuz.classroom.repository.ClassroomBookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件 ClassroomService 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
@Transactional
public class ClassroomService {
    private ClassroomBookRepository bookRepository;

    private ClassroomApplyRepository applyRepository;

    public ClassroomService(ClassroomBookRepository bookRepository, ClassroomApplyRepository applyRepository) {
        this.bookRepository = bookRepository;
        this.applyRepository = applyRepository;
    }

    public List<CrStatus> findClassroom(String day, String time, boolean book) {
        return bookRepository.findCrStatus(day, time, book);
    }

    public void updateClassroom(String day, String time, String classroom, boolean book) {
        bookRepository.update(day, time, classroom, book);
    }

    public void addApply(ClassroomApply apply) {
        applyRepository.addClassroomApply(apply);
    }

    public List<ClassroomApply> getApplies(String number, String status, int page) {
        return applyRepository.pageFind(number, status, page);
    }

    public void approveApply(int applyId, String status) {
        if (status.equals("refuse")) {
            ClassroomApply apply = applyRepository.find(applyId);
            bookRepository.update(apply.getDay(), apply.getTime(), apply.getClassroom(), true);
        }

        applyRepository.updateApply(applyId, status);
    }
}
