package com.forstudy.common.utils.config;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class BeanConfig {

    /*
        MongoDB 自动注入到IOC容器当中
     */
    @Bean
    public DB db() {

        return new MongoClient("localhost").getDB("blog");
    }
    /*
        Jedis 自动注入到IOC容器当中
     */
    @Bean
    public Jedis jedis() {

        return new Jedis("localhost");
    }
}
