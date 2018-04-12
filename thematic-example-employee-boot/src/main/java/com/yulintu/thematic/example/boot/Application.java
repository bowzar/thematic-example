package com.yulintu.thematic.example.boot;

import com.yulintu.thematic.data.GlobalApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Application {


    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory){
      return   RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaultCacheConfig())
                .initialCacheNames(cacheNames())
                .withInitialCacheConfigurations(cacheConfigurations())
        .transactionAware()
        .build();



    }

    private RedisCacheConfiguration defaultCacheConfig(){
       return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(10))
                .disableCachingNullValues();
    }

    private HashMap<String,RedisCacheConfiguration> cacheConfigurations(){
        HashMap<String, RedisCacheConfiguration> map = new HashMap<>();
        map.put("default",defaultCacheConfig());
        map.put("employee",RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofSeconds(20))
        .disableCachingNullValues()

        );

        return  map;
    }

    private  HashSet<String> cacheNames(){
        HashSet<String> names = new HashSet<>();
        names.add("default");
        names.add("employee");

        return  names;
    }


    public static void main(String[] args) {
        GlobalApplicationContext.setApplicationContext(
                SpringApplication.run(Application.class, args));
    }
}


