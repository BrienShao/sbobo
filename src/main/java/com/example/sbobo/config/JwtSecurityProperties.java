package com.example.sbobo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * JWT参数配置类
 *
 * @author 啵啵
 * @date 2021/12/12
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtSecurityProperties {

    /**
     * Request Header : Authorization
     */
    private String header;

    /**
     * 令牌前缀，最后留个空格 Bearer
     */
    private String tokenStartWith;

    /**
     * 必须使用至少88位的Base64对令牌进行编码
     */
    private String base64Secret;

    /**
     * 令牌过期时间
     */
    private Long tokenValidityInSeconds;

    /**
     * 在线用户 key，根据 key 查询 redis 中的在线用户数据
     */
    private String onlineKey;

    /**
     * 验证码 key
     */
    private String condeKey;

    /**
     * 返回令牌前缀
     * @return
     */
    public String getTokenStartWith() {
        return tokenStartWith + " ";
    }
}
