package com.example.sbobo.service.Impl;

import com.example.sbobo.dto.AuthUserDto;
import com.example.sbobo.entity.Result;
import com.example.sbobo.service.AuthService;
import com.example.sbobo.service.UserService;
import com.example.sbobo.service.WxMiniProgram;
import com.example.sbobo.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Value("${miniProgram.appId")
    private String appId;
    @Value("${miniProgram.secret")
    private String secret;

    private final JwtTokenUtil jwtTokenUtil;
    private final WxMiniProgram wxMiniProgram;
    private final UserService userService;

    public AuthServiceImpl(JwtTokenUtil jwtTokenUtil, WxMiniProgram wxMiniProgram, UserService userService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.wxMiniProgram = wxMiniProgram;
        this.userService = userService;
    }

    @Override
    public Result<AuthUserDto> login(AuthUserDto authUserDto, HttpServletRequest request) {
        return null;
    }
}
