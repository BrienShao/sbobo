package com.example.sbobo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;

/**
 * @author 啵啵
 * @date 2021/12/19
 */
@SpringBootTest
public class JwtTokenTests {

    @Test
    void jws() {

        // 密钥
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);    // or HS384 or HS512

        // 如果要保存密钥可以对它进行 Base64（或 Base64Url）编码
        //String secretString = Encoders.BASE64.encode(key.getEncoded());

        // 生成 JWS
        String jws = Jwts.builder()     // 使用 Jwts.builder() 方法创建 JwtBuilder 实例
                .setSubject("Bob")      // 调用 JwtBuilder 方法添加 header 参数和说明
                .signWith(key)          // 指定要用于签署 JWT 的密钥（SecretKey）或非对称私钥（PrivateKey）
                .compact();             // 调用 compact() 方法进行压缩和签名，生成最终的 jws
        System.out.println(key);
    }
}
