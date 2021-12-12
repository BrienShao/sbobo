package com.example.sbobo.service;

import com.example.sbobo.dto.AuthUserDto;
import com.example.sbobo.entity.Result;
import com.example.sbobo.util.JwtTokenUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
public class AuthServiceImpl implements AuthService{

    private String appId;
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
