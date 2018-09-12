package club.springboot.dubbo.dubboserver.service.impl;

import club.springboot.dubbo.service.AccountService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service(version = "1.0.0")
@Component
public class AccountServiceImpl implements AccountService {

    @Override
    public String loginByPhone(String accountName, String password) {
        return accountName + " " + password;
    }

}
