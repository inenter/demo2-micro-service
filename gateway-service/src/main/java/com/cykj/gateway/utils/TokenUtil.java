package com.cykj.gateway.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * @author: LQB
 * @Description:
 * @create: 2023/2/2 11:32
 */
public class TokenUtil {

    // 加密
    public static String createToken(String acc){
//        Date start = new Date();
//        long currentTime = System.currentTimeMillis() + 60 * 1000 * 10;     // 十分钟有效
//        Date end = new Date(currentTime);
        return JWT.create()
                .withAudience(acc)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 1000 * 10))
                .sign(Algorithm.HMAC256(acc));
    }

    // 解密
    public static String getToken(String token){
        return JWT.decode(token).getAudience().get(0);
    }

//    public static void main(String[] args) {
//        String acc = "lqb";
//        String token = createToken(acc);
//        System.out.println(token);
//        System.out.println(getToken(token));
//    }

}
