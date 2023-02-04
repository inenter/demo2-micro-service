//package com.cykj.gateway.config;
//
//import com.alibaba.fastjson.JSON;
//import com.cykj.gateway.utils.RedisUtil;
//import com.cykj.gateway.utils.TokenUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.util.Assert;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.HashMap;
//import java.util.Map;
//
//
///**
// * @author: LQB
// * @Description:
// * @create: 2023/2/2 10:21
// */
//@Configuration
//public class AuthenticationConfig implements GlobalFilter {
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//                            // 请求和应答的上下文         过滤链
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // 测试redis
//        boolean re = redisUtil.set("key1","刘秋标");
//        Assert.isTrue(re,"success");
//
//        ServerHttpRequest request = exchange.getRequest();
//        System.out.println("打印：" + request);
//        System.out.println("完全路径：" + request.getURI());
//        System.out.println("具体路由：" + request.getPath());
//        String url = request.getURI().getPath();
//        // 1.判断是否在白名单
//        if (url.contains("login") || url.contains("register")){
//            return chain.filter(exchange);  // 通行
//        }
//        // 2.是否有token    （token放在请求头中）
//        String token = request.getHeaders().getFirst("token");
//        if (token == null) {
//            Map<String, Object> result = new HashMap<String, Object>();
//            result.put("code", 401);
//            result.put("message", "没有token, 请先登录");
//            ServerHttpResponse response = exchange.getResponse();
//            // 将http的状态设置为401
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            // 将http协议的应答类型设置为application/json
//            response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//            // 将JSON字符串转换为字节流（buffer流）
//            DataBuffer dataBuffer = response.bufferFactory().wrap(JSON.toJSONString(result).getBytes());
//            return response.writeWith(Mono.just(dataBuffer));
//        }
//        // 3.校验token是否合法
////        String acc = TokenUtil.getToken(token);
//        // 判断账号是否存在  是否过期
//
//        // 4.请求是否有权限（匹配权限）
//        return  null;
//    }
//
//}
