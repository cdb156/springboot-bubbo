package club.springboot.dubbo.dubboactivemqserver.listener;

import club.springboot.dubbo.dto.activemq.MessageModel;
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
    }

    @JmsListener(destination = "test-sendTopicMessage")
    public void testRecaiveTopic(String test) throws InterruptedException {
        logger.info("test-sendTopicMessage 接受消息: - > " + test);
    }

    @JmsListener(destination = "test-sendObject")
    public void receiceObject(MessageModel messageModel) {
        logger.info("test-sendObject 接受消息: - > " + messageModel);
    }


}
