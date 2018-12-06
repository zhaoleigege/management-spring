package cn.edu.bnuz.course.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

/**
 * 文件 ActiveMqConfig 创建于 2018/4/20
 *
 * @author 赵磊
 * @version 1.0
 */
@Configuration
public class ActiveMqConfig {
    public static final String STUDENT_INFO = "muduo.student";

    @Bean
    public ActiveMQQueue siQueue() {
        return new ActiveMQQueue(STUDENT_INFO);
    }

    @Bean
    public MessageConverter jsonJmsMessageConverter() {
        MappingJackson2MessageConverter json = new MappingJackson2MessageConverter();
        json.setTargetType(MessageType.TEXT);
        json.setTypeIdPropertyName("_type");

        return json;
    }

    @Bean
    public JmsListenerContainerFactory<?> scListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jsonJmsMessageConverter());
        return factory;
    }
}
