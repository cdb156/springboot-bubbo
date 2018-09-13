package club.springboot.dubbo.service;

import club.springboot.dubbo.po.User;

public interface AccountService {

    User loginByPhone(String phone);

    User loginByUserName(String accountName);

    User selectUserAndUserID(Integer userId);

    Integer saveUser(User user);

    String sendMessage();
}
