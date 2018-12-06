package cn.edu.bnuz.account.mq;

import cn.edu.bnuz.domain.user.Account;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static cn.edu.bnuz.account.mq.ActiveMqConfig.STUDENT_INFO;

/**
 * 文件 MqProducer 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@Service
public class MqProducer {
    private JmsTemplate template;

    public MqProducer(JmsTemplate template) {
        this.template = template;
    }

    public void lookupSc(Account account) {
        template.convertAndSend(STUDENT_INFO, account);
    }
}
