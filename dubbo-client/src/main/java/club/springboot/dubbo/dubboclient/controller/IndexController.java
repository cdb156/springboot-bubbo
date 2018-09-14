package club.springboot.dubbo.dubboclient.controller;

import club.springboot.dubbo.po.User;
import club.springboot.dubbo.service.DubboAccountService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Reference(version = "1.0.0")
    private DubboAccountService dubboAccountService;

    @GetMapping("/user/{accountName}")
    @ResponseBody
    public User index(@PathVariable("accountName")String accountName) {
        User user = dubboAccountService.loginByPhone(accountName);
        if (user == null) {
            user = dubboAccountService.loginByUserName(accountName);
        }
        return user;
    }

    @GetMapping("/user/{userId}/all")
    @ResponseBody
    public User selectUserAndUserID(@PathVariable("userId")Integer userId) {
        return dubboAccountService.selectUserAndUserID(userId);
    }

    @PostMapping("/user")
    @ResponseBody
    public Integer addUser(User user) {
        return dubboAccountService.saveUser(user);
    }

    @GetMapping("/testActiveMqQueue")
    @ResponseBody
    public String testActiveMqQueue() {
        return dubboAccountService.sendMessage();
    }


    @GetMapping("/testActiveMqTopic")
    @ResponseBody
    public String testActiveMqTopic() {
        return dubboAccountService.sendMessageTopic();
    }

    @GetMapping("/testActivMqObject/{userId}")
    @ResponseBody
    public String testActivMqObject(@PathVariable("userId") Integer userId) {
        return dubboAccountService.sendObjectQueue(userId);
    }

}
