package cn.edu.bnuz.stuff.service;

import cn.edu.bnuz.domain.stuff.Stuff;
import cn.edu.bnuz.stuff.repository.StuffRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件 StuffService 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
@Transactional
public class StuffService {
    private StuffRepository stuffRepository;

    public StuffService(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }

    public void insertStuff(Stuff stuff) {
        stuffRepository.insert(stuff);
    }

    public Stuff findStuff(int stuffId) {
        return stuffRepository.find(stuffId);
    }

    public List<Stuff> pageFind(String type, int page) {
        return stuffRepository.pageFind(type, page);
    }
}
