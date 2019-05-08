package com.netstudy;

import com.netstudy.common.init.StartupRunner;
import com.netstudy.common.init.TaskRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.netstudy.dao")
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

/*
    @Bean
    public StartupRunner startupRunner() {

        return new StartupRunner();
    }

    @Bean
    public TaskRunner taskRunner() {

        return new TaskRunner();
    }
*/
}
