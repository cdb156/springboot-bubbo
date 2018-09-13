package club.springboot.dubbo.dubboserver.service.impl;

import club.springboot.dubbo.dubboserver.dao.mapper.UserMapper;
import club.springboot.dubbo.po.User;
import club.springboot.dubbo.service.AccountService;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service(version = "1.0.0")
@Component
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
        return userMapper.saveUser(user);
    }

    @Override
    public String sendMessage() {
        String s = "开始发送消息 -> dubbo-server";
         for (int i = 0; i < 10 ; i++) {
             jmsMessagingTemplate.convertAndSend(new ActiveMQQueue("test-sendMessage"), "this is a test for activemq " + i);
         }
        return s;
    }

}
