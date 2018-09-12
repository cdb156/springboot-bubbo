package club.springboot.dubbo.dubboserver.service.impl;

import club.springboot.dubbo.dubboserver.dao.mapper.UserMapper;
import club.springboot.dubbo.po.User;
import club.springboot.dubbo.service.AccountService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service(version = "1.0.0")
@Component
public class AccountServiceImpl implements AccountService {

    @Autowired(required = false)
    private UserMapper userMapper;

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

}
