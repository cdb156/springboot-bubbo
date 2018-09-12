package club.springboot.dubbo.dubboserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//使用 mapper 注解可以 不用添加 MapperScan
//@MapperScan("club.springboot.dubbo.dubboserver.dao.mapper")
public class DubboServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboServerApplication.class, args);
    }
}
