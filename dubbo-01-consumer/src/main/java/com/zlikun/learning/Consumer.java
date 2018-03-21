package com.zlikun.learning;

import com.zlikun.learning.rpc.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-03-21 21:22
 */
@Slf4j
public class Consumer {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:beans-dubbo-consumer.xml"});
        context.start();

        HelloService helloService = context.getBean(HelloService.class);
        String message = helloService.say("zlikun");
        log.info("rpc response : {}", message);

        context.stop();
        context.close();
    }

}
