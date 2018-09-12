package club.springboot.dubbo.dubboclient.controller;

import club.springboot.dubbo.service.AccountService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

    @Reference(version = "1.0.0")
    private AccountService accountService;

    @GetMapping("/index")
    @ResponseBody
    public String index() {

        return accountService.loginByPhone("lidejie", "tests");
    }

}
