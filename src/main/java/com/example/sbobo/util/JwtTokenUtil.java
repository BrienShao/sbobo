package com.example.sbobo.util;

import com.example.sbobo.config.JwtSecurityProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * JWT工具类
 *
 * @author 啵啵
 * @date 2021/12/12
 */
@Slf4j
@Component
public class JwtTokenUtil implements InitializingBean {

    private final JwtSecurityProperties jwtSecurityProperties;
    private static final String AUTHORITIES_KEY = "auth";
    private Key key;

    public JwtTokenUtil(JwtSecurityProperties jwtSecurityProperties) {
        this.jwtSecurityProperties = jwtSecurityProperties;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecurityProperties.getBase64Secret());
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(String subject, Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(subject)
                .claim(AUTHORITIES_KEY, claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtSecurityProperties.getTokenValidityInSeconds()))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
