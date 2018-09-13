package club.springboot.dubbo.dubboserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//使用 mapper 注解可以 不用添加 MapperScan
//@MapperScan("club.springboot.dubbo.dubboserver2.dao.mapper")
public class DubboServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(DubboServer2Application.class, args);
    }
}
