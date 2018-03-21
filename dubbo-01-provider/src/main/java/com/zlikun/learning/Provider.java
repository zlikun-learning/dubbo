package com.zlikun.learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Dubbo服务提供程序入口
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-03-21 20:52
 */
@Slf4j
public class Provider {

    public static void main(String[] args) throws Exception {

        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:beans-dubbo-provider.xml"});
        context.start();

        // 释放资源
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                context.stop();
                context.close();
                log.info("Dubbo service was closed ...");
            }
        });

        log.info("Dubbo service is running ...");

        // 程序阻塞30分钟 ( 测试 )
        Thread.currentThread().join(30 * 60 * 1000L);

    }

}
