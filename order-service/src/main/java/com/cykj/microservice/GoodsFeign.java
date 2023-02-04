package com.cykj.microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: LQB
 * @Description:
 * @create: 2023/2/1 11:01
 */

@FeignClient(name = "goods-service", path = "/goods")
public interface GoodsFeign {

    @RequestMapping("/find")
    public String find();

}
