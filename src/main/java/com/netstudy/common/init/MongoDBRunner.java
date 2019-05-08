package com.netstudy.common.init;

import com.netstudy.common.quartz.MainScheduler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MongoDBRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {

        try {
            MainScheduler.schedulerJob();
        } catch (Exception e) {
            System.out.println("RunTime Error");
        }
    }
}
