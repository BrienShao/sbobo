package com.example.sbobo.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

/**
 * @author 啵啵
 * @date 2021/11/28
 */
@RestController
@RequestMapping("/index")
public class Index {

    @GetMapping("")
    public String index() {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String jws = Jwts.builder().setSubject("sbobo").signWith(key).compact();
        return jws;
    }
}
