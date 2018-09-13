package club.springboot.dubbo.dubboclient.controller;

import club.springboot.dubbo.po.User;
import club.springboot.dubbo.service.AccountService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Reference(version = "1.0.0")
    private AccountService accountService;

    @GetMapping("/user/{accountName}")
    @ResponseBody
    public User index(@PathVariable("accountName")String accountName) {
        User user = accountService.loginByPhone(accountName);
        if (user == null) {
            user = accountService.loginByUserName(accountName);
        }
        return user;
    }

    @GetMapping("/user/{userId}/all")
    @ResponseBody
    public User selectUserAndUserID(@PathVariable("userId")Integer userId) {
        return accountService.selectUserAndUserID(userId);
    }

    @PostMapping("/user")
    @ResponseBody
    public Integer addUser(User user) {
        return accountService.saveUser(user);
    }

    @GetMapping("/testActiveMq")
    @ResponseBody
    public String testActiveMq() {
        return accountService.sendMessage();
    }

}
