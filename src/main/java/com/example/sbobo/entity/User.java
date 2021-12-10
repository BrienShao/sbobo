package com.example.sbobo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 小程序openID
     */
    @Column(unique = true)
    private String openId;
    /**
     * 公众号unionID
     */
    private String unionId;
    /**
     * 小程序sessionKey
     */
    private String sessionKey;
    /**
     * 用户名
     */
    @Column(unique = true)
    private String userName;
    /**
     * 密码
     * @JsonIgnore 在json序列化时将pojo中的一些属性忽略掉，标记在属性或者方法上，返回的json数据即不包含该属性
     */
    @JsonIgnore
    private String password;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像地址
     */
    private String avatarUrl;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 电话
     */
    private String phone;
    /**
     * 用户状态
     */
    private Boolean status;
    /**
     * 创建时间
     */
    @JsonIgnore
    @CreationTimestamp
    private Timestamp createTime;
    /**
     * 修改时间
     */
    @JsonIgnore
    @UpdateTimestamp
    private Timestamp updateTime;
}
