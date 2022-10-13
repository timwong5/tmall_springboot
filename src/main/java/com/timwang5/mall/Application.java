package com.timwang5.mall;


import com.timwang5.mall.util.PortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author timwong5
 */
@SpringBootApplication
@EnableCaching
@EnableElasticsearchRepositories(basePackages = "com.timwang5.mall.es")
@EnableJpaRepositories(basePackages = {"com.timwang5.mall.dao", "com.timwang5.mall.pojo"})
public class Application {

    static {
        PortUtil.checkPort(6379,"Redis 服务端",true);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
