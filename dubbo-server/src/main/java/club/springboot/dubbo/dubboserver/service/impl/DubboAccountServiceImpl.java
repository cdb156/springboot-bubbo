package club.springboot.dubbo.dubboserver.service.impl;

import club.springboot.dubbo.po.User;
import club.springboot.dubbo.realservice.AccountService;
import club.springboot.dubbo.service.DubboAccountService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service(version = "1.0.0", interfaceClass = DubboAccountService.class, timeout = 300000, retries = 0, delay = -1)
@Component
public class DubboAccountServiceImpl implements DubboAccountService {

    @Autowired
    private AccountService accountService;

    @Override
    public User loginByPhone(String phone) {
        return accountService.loginByPhone(phone);
    }

    @Override
    public User loginByUserName(String accountName) {
        return accountService.loginByUserName(accountName);
    }

    @Override
    public User selectUserAndUserID(Integer userId) {
        return accountService.selectUserAndUserID(userId);
    }

    @Override
    public Integer saveUser(User user) {
        return accountService.saveUser(user);
    }

    @Override
    public String sendMessage() {
        return accountService.sendMessage();
    }

    @Override
    public String sendMessageTopic() {
        return accountService.sendMessageTopic();
    }

    @Override
    public String sendObjectQueue(Integer userId) {
        return accountService.sendObjectQueue(userId);
    }
}
