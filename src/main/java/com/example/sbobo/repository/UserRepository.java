package com.example.sbobo.repository;

import com.example.sbobo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户DAO接口层
 *
 * @author 啵啵
 * @date 2021/12/23
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
