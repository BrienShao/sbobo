package com.example.sbobo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 啵啵
 * @Create 2021/11/28
 */
@RestController
@RequestMapping("/index")
public class Index {

    @GetMapping("")
    public String index() {
        return "Hello World";
    }
}
