# springboot-bubbo
## 1. springboot + dubbo + zookeeper 三者结合搭建分布式服务

### 1. 新建父项目, 用于 引入公用的 依赖
> dubbo + zookeeper
```
 <!--dubbo + zookeeper-->
        <dependency>
            <groupId>io.dubbo.springboot</groupId>
            <artifactId>spring-boot-starter-dubbo</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.6</version>
        </dependency>
```
 
### 2. 在父类项目下新建 Module dubbo-bean, 用于 存放公用的数据对象 

### 3. 在父类项目下新建 Module dubbo-api, 用于 存放公用的接口
> 在 pom 文件中导入 dubbo-bean 依赖

### 4. 在父类项目下新建 Module dubbo-server, 作为服务的 提供者
> 在 pom 文件中导入 dubbo-bean , dubbo-api 依赖
> 在 properties 文件中配置 dubbo 服务提供者的一些信息
  ```
## 同一台机器避免端口冲突
server.port=8088
## Dubbo 服务提供者配置
#--服务名称
spring.dubbo.application.name=provider
#-- 注册中心地址
spring.dubbo.registry.address=zookeeper://127.0.0.1:2181
#-- dubbo 协议
spring.dubbo.protocol.name=dubbo
spring.dubbo.protocol.port=20880
#--声明需要暴露的服务接口(实现类, 会自动寻找上层接口)
spring.dubbo.scan=club.springboot.dubbo.dubboserver.service
  ```
  
### 5. 在父类项目下新建 Module dubbo-client, 作为服务的 消费者
> 在 pom 文件中导入 dubbo-bean , dubbo-api 依赖
> 在properties 文件中 配置doubbo 消费者 的信息
 
```
## 同一台机器避免端口冲突
server.port=8889
# application name
spring.dubbo.application.name=consumer
# zookeeper 注册中心
spring.dubbo.registry.address=zookeeper://127.0.0.1:2181
# 扫描注解的位置(注入注解的位置)(不建议直接把 服务注入 controller 层)
spring.dubbo.scan=club.springboot.dubbo.dubboclient.controller
```

### 6. 最终的项目结构

![image](https://github.com/lidejie/picture/blob/master/springboot-duboo%E9%A1%B9%E7%9B%AE%E7%BB%93%E6%9E%84.png)

# END

