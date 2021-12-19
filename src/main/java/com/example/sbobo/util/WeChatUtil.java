package com.example.sbobo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
@Slf4j
public class WeChatUtil {

    public static String httpRequest(String requestUrl, String requestMethod, String output) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(requestMethod);

            if (null != output) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(output.getBytes(StandardCharsets.UTF_8));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String decryptData(String encryptDataBase64, String sessionKeyBase64, String ivBase64) {
        log.info("encryptDataBase64: " + encryptDataBase64);
        log.info("sessionKeyBase64: " + sessionKeyBase64);
        log.info("ivBase64: " + ivBase64);
        return new String(
                decryptOfDiyIv(
                        Base64.getDecoder().decode(encryptDataBase64),
                        Base64.getDecoder().decode(sessionKeyBase64),
                        Base64.getDecoder().decode(ivBase64)
                )
        );
    }

    private static byte[] decryptOfDiyIv(byte[] encryptData, byte[] sessionKey, byte[] iv) {
        byte[] encryptedText = null;
        return encryptedText;
    }
}
