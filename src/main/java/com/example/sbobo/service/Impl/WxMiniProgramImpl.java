package com.example.sbobo.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.sbobo.service.WxMiniProgram;
import com.example.sbobo.util.WeChatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
@Slf4j
@Service
public class WxMiniProgramImpl implements WxMiniProgram {

    @Override
    public JSONObject authCode2Session(String appid, String secret, String js_code) {

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid
                + "&secret=" + secret + "&js_code=" + js_code + "&grant_type=authorization_code";
        String str = WeChatUtil.httpRequest(url, "GET", null);
        log.info("api/wx_miniProgram/getSessionKey：" + str);
        if (StringUtils.hasLength(str)) {
            return null;
        } else {
            return JSONObject.parseObject(str);
        }
    }
}
