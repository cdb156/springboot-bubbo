package club.springboot.dubbo.dubboserver.service.realimpl;

import club.springboot.dubbo.dto.activemq.MessageModel;
import club.springboot.dubbo.dubboserver.dao.mapper.UserMapper;
import club.springboot.dubbo.po.User;
import club.springboot.dubbo.realservice.AccountService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ldj
 * @date 2018/09/14
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public User loginByPhone(String phone) {
        return userMapper.getByPhone(phone);
    }

    @Override
    public User loginByUserName(String accountName) {
        return userMapper.getByUserName(accountName);
    }

    @Override
    public User selectUserAndUserID(Integer userId) {
        return userMapper.selectUserAndUserID(userId);
    }

    @Override
    public Integer saveUser(User user) {
        userMapper.saveUser(user);
        return userMapper.saveUser(user);
    }

    @Override
    public String sendMessage() {
        logger.info("server 1 开始处理消息");
        String s = "开始发送消息 -> dubbo-server1";
        for (int i = 0; i < 10; i++) {
            jmsMessagingTemplate.convertAndSend(new ActiveMQQueue("test-sendMessage"), "this is a test for activemq " + i);
        }
        return s;
    }

    @Override
    public String sendMessageTopic() {
        logger.info("server 1 开始发送订阅消息");
        String s = "开始发送订阅消息 -> dubbo-server1";
        for (int i = 0; i < 10; i++) {
            jmsMessagingTemplate.convertAndSend(new ActiveMQTopic("test-sendTopicMessage"), "this is a test for activemq topic" + i);
        }
        return s;
    }

    @Override
    public String sendObjectQueue(Integer userId) {
        User user = userMapper.getById(userId);
        logger.info("server 1 开始处理消息, 准备处理对象 : {}", user);
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue("test-sendObject"), new MessageModel<User>("this is a test for object", user));
        return String.format("server 1 开始处理消息, 准备处理对象 : %s", user != null ? user : "null");
    }

}
