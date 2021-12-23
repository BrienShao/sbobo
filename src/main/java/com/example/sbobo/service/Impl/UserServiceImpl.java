package com.example.sbobo.service.Impl;

import com.example.sbobo.base.Result;
import com.example.sbobo.entity.User;
import com.example.sbobo.repository.UserRepository;
import com.example.sbobo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 啵啵
 * @date 2021/12/19
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result<User> createOrUpdate(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Result<User> findById(Long id) {
        return null;
    }

    @Override
    public Result<User> findByOpenId(String openId) {
        return null;
    }

    @Override
    public Result<User> findByUserName(String userName) {
        return null;
    }
}
