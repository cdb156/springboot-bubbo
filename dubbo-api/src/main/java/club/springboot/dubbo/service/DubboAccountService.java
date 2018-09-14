package club.springboot.dubbo.service;

import club.springboot.dubbo.po.User;

public interface DubboAccountService {

    User loginByPhone(String phone);

    User loginByUserName(String accountName);

    User selectUserAndUserID(Integer userId);

    Integer saveUser(User user);

    String sendMessage();

    String sendMessageTopic();

    String sendObjectQueue(Integer userId);
}
