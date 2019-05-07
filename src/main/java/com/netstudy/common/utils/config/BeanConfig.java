package com.netstudy.common.utils.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.netstudy.common.bean.Remarks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class BeanConfig {

    @Remarks("MongoDB 自动注入到IOC容器当中")
    @Bean
    public DB db() {

        return new MongoClient("localhost").getDB("blog");
    }

    @Remarks("Jedis 自动注入到IOC容器当中")
    @Bean
    public Jedis jedis() {

        return new Jedis("localhost");
    }

    @Remarks(" 注入到IOC容器，统一管理 ")
    @Bean
    public MongoDatabase mongoDatabase() {

        return new MongoClient("localhost").getDatabase("blog");
    }
}
