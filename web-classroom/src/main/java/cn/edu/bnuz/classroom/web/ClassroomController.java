package cn.edu.bnuz.classroom.web;

import cn.edu.bnuz.classroom.entity.ClassroomApply;
import cn.edu.bnuz.classroom.entity.CrStatus;
import cn.edu.bnuz.classroom.form.ApplyForm;
import cn.edu.bnuz.classroom.form.ApproveForm;
import cn.edu.bnuz.classroom.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * 文件 ClassroomController 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@RestController
public class ClassroomController {
    private ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("classrooms/{day}/{time}")
    public List<CrStatus> getClassrooms(@PathVariable String day, @PathVariable String time) {
        return classroomService.findClassroom(day, time, true);
    }

    @PostMapping("classrooms/applies")
    public void getApply(Principal principal, @RequestBody ApplyForm form) {
        classroomService.addApply(new ClassroomApply(principal.getName(), form.getDay(), form.getTime(),
                form.getClassroom(), form.getReason(), "applying", new Date()));

        classroomService.updateClassroom(form.getDay(), form.getTime(), form.getClassroom(), false);
    }

    @GetMapping("classrooms/applies")
    public List<ClassroomApply> getApplies(String status, int page) {
        return classroomService.getApplies(null, status, page);
    }

    @GetMapping("classrooms/me/applies")
    public List<ClassroomApply> getMyApplies(Principal principal, String status, int page) {
        return classroomService.getApplies(principal.getName(), status, page);
    }

    @PutMapping("classrooms/applies")
    public void updateApply(@RequestBody ApproveForm form) {
        classroomService.approveApply(form.getApplyId(), form.getStatus());
    }
}
