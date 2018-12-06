package cn.edu.bnuz.stuff.repository;

import cn.edu.bnuz.domain.stuff.Stuff;

import java.util.List;

/**
 * 文件 StuffRepository 创建于 2018/4/18
 *
 * @author 赵磊
 * @version 1.0
 */
public interface StuffRepository {
    void insert(Stuff stuff);

    Stuff find(int stuffId);

    List<Stuff> pageFind(String type, int page);
}
