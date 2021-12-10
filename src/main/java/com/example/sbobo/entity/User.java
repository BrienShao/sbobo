package com.example.sbobo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.sql.Update;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
@Data
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Update.class)
    private Integer userID;         // 用户ID
    private String openID;          // 小程序openID
    private String unionID;         // 公众号unionID
    private String sessionKey;      // 小程序sessionKey
    @Column(name = "user_name", unique = true)
    private String userName;        // 用户名
    @JsonIgnore
    private String password;        // 密码
    private String nickName;        // 昵称
    private String avatarUrl;       // 头像地址
    private Integer gender;         // 性别
    private String phone;           // 电话
    private Boolean status;         // 用户状态
    private Timestamp createTime;   // 创建时间
    private Timestamp updateTime;   // 修改时间
}
