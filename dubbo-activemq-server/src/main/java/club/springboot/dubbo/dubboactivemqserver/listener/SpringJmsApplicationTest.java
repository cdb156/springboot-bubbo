package club.springboot.dubbo.dubboactivemqserver.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author ldj
 * @date 2018/09/13
 */
@Component
public class SpringJmsApplicationTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "test-sendMessage")
    public void testRecaiveQueue(String test) throws InterruptedException {
        logger.info("test-sendMessage 接受消息: - > " + test);
        Thread.sleep(10000);
    }



}
