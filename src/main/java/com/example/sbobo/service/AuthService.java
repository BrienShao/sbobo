package com.example.sbobo.service;

import com.example.sbobo.dto.AuthUserDto;
import com.example.sbobo.entity.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
public interface AuthService {

    /**
     * 登录授权
     * @param authUserDto   认证用户请求信息
     * @param request   Http请求
     * @return  返回认证用户信息
     */
    Result<AuthUserDto> login(AuthUserDto authUserDto, HttpServletRequest request);
}
