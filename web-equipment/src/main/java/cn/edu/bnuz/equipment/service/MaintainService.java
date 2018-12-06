package cn.edu.bnuz.equipment.service;

import cn.edu.bnuz.domain.equipment.Maintain;
import cn.edu.bnuz.equipment.repository.MainRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件 MaintainService 创建于 2018/4/19
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
@Transactional
public class MaintainService {
    private MainRepository repository;

    public MaintainService(MainRepository repository) {
        this.repository = repository;
    }

    public void insert(Maintain maintain) {
        repository.insert(maintain);
    }

    public Maintain find(int maintainId) {
        return repository.find(maintainId);
    }

    public void update(int maintainId, String repairNumber) {
        repository.repairUpdate(maintainId, repairNumber);
    }

    public List<Maintain> reportPageFind(int page) {
        return repository.reportPageFind(page);
    }

    public List<Maintain> repairedPageFind(String repairNumber, int page) {
        return repository.repairedPageFind(repairNumber, page);
    }
}
