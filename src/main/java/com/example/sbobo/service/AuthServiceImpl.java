package com.example.sbobo.service;

import com.example.sbobo.dto.AuthUserDto;
import com.example.sbobo.entity.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
public class AuthServiceImpl implements AuthService{

    private String appId;
    private String secret;

    private final JwtTokenUtils jwtTokenUtils;
    private final WxMiniProgram wxMiniProgram;
    private final UserService userService;

    public AuthServiceImpl(JwtTokenUtils jwtTokenUtils, WxMiniProgram wxMiniProgram, UserService userService) {
        this.jwtTokenUtils = jwtTokenUtils;
        this.wxMiniProgram = wxMiniProgram;
        this.userService = userService;
    }

    @Override
    public Result<AuthUserDto> login(AuthUserDto authUserDto, HttpServletRequest request) {
        return null;
    }
}
