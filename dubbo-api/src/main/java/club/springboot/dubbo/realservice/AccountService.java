package club.springboot.dubbo.realservice;

import club.springboot.dubbo.po.User;

/**
 * @author ldj
 * @date 2018/09/14
 */
public interface AccountService {
    User loginByPhone(String phone);

    User loginByUserName(String accountName);

    User selectUserAndUserID(Integer userId);

    Integer saveUser(User user);

    String sendMessage();

    String sendMessageTopic();

    String sendObjectQueue(Integer userId);
}
