package com.example.sbobo.service;

import com.example.sbobo.base.Result;
import com.example.sbobo.entity.User;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
public interface UserService {

    /**
     * 增加用户
     *
     * @param user 待新增或修改的用户
     * @return 操作成功的用户
     */
    Result<User> createOrUpdate(User user);

    /**
     * 删除用户
     *
     * @param user 待删除的用户
     */
    void delete(User user);

    /**
     * 根据 id 查找用
     *
     * @param id 用户id
     * @return id对应的用户
     */
    Result<User> findById(Long id);

    /**
     * 根据 openId 查找用户
     *
     * @param openId 微信 openId
     * @return openId对应的用户
     */
    Result<User> findByOpenId(String openId);

    /**
     * 根据 userName 查找用
     *
     * @param userName 用户名
     * @return 用户名对应的用户
     */
    Result<User> findByUserName(String userName);
}
