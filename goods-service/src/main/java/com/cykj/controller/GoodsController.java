package com.cykj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: LQB
 * @Description:
 * @create: 2023/1/31 11:52
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/find")
    public String find(){
        System.out.println("调用了。。。。。");
        return "goods-find: " + port;
    }

}