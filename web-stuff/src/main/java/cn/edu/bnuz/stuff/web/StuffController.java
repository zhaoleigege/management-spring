package cn.edu.bnuz.stuff.web;

import cn.edu.bnuz.domain.stuff.Stuff;
import cn.edu.bnuz.stuff.form.StuffForm;
import cn.edu.bnuz.stuff.service.StuffService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * 文件 StuffController 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@RestController
public class StuffController {
    private ObjectMapper objectMapper;

    private StuffService stuffService;

    public StuffController(ObjectMapper objectMapper, StuffService stuffService) {
        this.objectMapper = objectMapper;
        this.stuffService = stuffService;
    }

    @PostMapping("")
    public void addLosses(Principal principal, @RequestBody StuffForm stuffForm) throws JsonProcessingException {
        Stuff stuff = new Stuff(principal.getName(), stuffForm.getType(),
                stuffForm.getPhone(), stuffForm.getDescription(), objectMapper.writeValueAsString(stuffForm.getImages()),
                new Date());

        stuffService.insertStuff(stuff);
    }

    @GetMapping("/{stuffId}")
    public Stuff getStuff(@PathVariable int stuffId) {
        return stuffService.findStuff(stuffId);
    }

    @GetMapping("/batch/{type}/{page}")
    public List<Stuff> getStuffList(@PathVariable String type, @PathVariable int page) {
        return stuffService.pageFind(type, page);
    }
}
