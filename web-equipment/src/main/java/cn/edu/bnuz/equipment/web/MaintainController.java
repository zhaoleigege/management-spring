package cn.edu.bnuz.equipment.web;

import cn.edu.bnuz.domain.equipment.Maintain;
import cn.edu.bnuz.equipment.form.MaintainForm;
import cn.edu.bnuz.equipment.service.MaintainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * 文件 MaintainController 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@RestController
public class MaintainController {
    private ObjectMapper mapper;

    private MaintainService service;

    public MaintainController(ObjectMapper mapper, MaintainService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping("maintains")
    public void addMaintain(Principal principal, @RequestBody MaintainForm maintainForm) throws JsonProcessingException {
        Maintain maintain = new Maintain(principal.getName(), maintainForm.getType(), maintainForm.getClassroom(), maintainForm.getDescription(), mapper.writeValueAsString(maintainForm.getImages()), new Date());
        if (maintainForm.getType().equals("maintain")) {
            maintain.setStatus("repaired");
            maintain.setRepairNumber(principal.getName());
        } else
            maintain.setStatus("repairing");

        service.insert(maintain);
    }

    @GetMapping("maintains/{maintainId}")
    public Maintain getMaintain(@PathVariable int maintainId) {
        return service.find(maintainId);
    }

    @GetMapping("maintains/repairing/batch/{page}")
    public List<Maintain> getRepairingList(@PathVariable int page) {
        return service.reportPageFind(page);
    }

    @GetMapping("maintains/repaired/batch/{page}")
    public List<Maintain> getRepairedList(Principal principal, @PathVariable int page) {
        return service.repairedPageFind(principal.getName(), page);
    }

    @PutMapping("maintains/{maintainId}")
    public void updateMaintain(Principal principal, @PathVariable Integer maintainId) {
        service.update(maintainId, principal.getName());
    }
}
