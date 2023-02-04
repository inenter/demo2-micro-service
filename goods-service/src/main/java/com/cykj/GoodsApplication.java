package com.cykj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: LQB
 * @Description:
 * @create: 2023/1/31 10:36
 */
@SpringBootApplication
//@LoadBalancerClient
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

    @Bean
    @LoadBalanced //加入负载均衡器
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


}
