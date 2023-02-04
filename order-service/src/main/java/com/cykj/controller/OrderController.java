package com.cykj.controller;

import com.cykj.microservice.GoodsFeign;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: LQB
 * @Description:
 * @create: 2023/1/31 12:08
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Autowired
    private GoodsFeign goodsFeign;

    @RequestMapping("/add")
    public String add(){
        // 创建订单
        // 减少库存
//        String resp = restTemplate.getForObject("http://localhost:9002/goods/find", String.class);
//        String resp = restTemplate.getForObject("http://goods-service/goods/find", String.class);
        String resp = goodsFeign.find();
        System.out.println("数据：");
        System.out.println(resp);
        return "order-add";
    }

    @RequestMapping("/add2")
    public String add2(){
        // 发送减库存的消息
        // 消息：JSON格式
        // 生产者
        rocketMQTemplate.convertAndSend("order-test", "HUAWEI nova 10se 20台");
        return "order-add2";
    }

}
