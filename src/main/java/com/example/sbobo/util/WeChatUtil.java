package com.example.sbobo.util;

import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;

/**
 * 微信小程序工具类
 *
 * @author 啵啵
 * @date 2021/12/10
 */
public class WeChatUtil {

    public static boolean initialized = false;

    private static void initialized() {
        if (initialized) {
            return;
        }
        Security.addProvider(new BouncyCastleProvider());
        initialized = true;
    }

    /**
     * 生成iv
     *
     * @param ivByte
     * @return
     */
    private static AlgorithmParameters generateIV(byte[] ivByte) {
        AlgorithmParameters parameters = null;
        try {
            parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parameters;
    }

    /**
     * AES 解密
     *
     * @param content   解密的目标密文
     * @param keyByte   解密秘钥
     * @param ivByte    解密算法初始向量
     * @return
     */
    private static byte[] decrypt(byte[] content, byte[] keyByte, byte[] ivByte) {
        initialized();

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");
            /**
             * 初始化
             */
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, generateIV(ivByte));
            byte[] result = cipher.doFinal(content);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final Charset CHARSET = Charset.forName("UTF-8");
    private static final int BLOCK_SIZE = 32;

    /**
     * 获取对明文进行补位填充的字节
     *
     * @param count 需要进行填充补位操作的明文字节个数
     * @return      补齐用的字节数组
     */
    private static byte[] encode(int count) {
        int amountToPad = BLOCK_SIZE - (count % BLOCK_SIZE);
        if (amountToPad == 0) {
            amountToPad = BLOCK_SIZE;
        }
        char padCharr = charr(amountToPad);
        String temp = new String();
        for (int index = 0; index < amountToPad; index++) {
            temp += padCharr;
        }
        return temp.getBytes(CHARSET);
    }

    /**
     * 删除解密后明文的补位字符
     *
     * @param decrypted 解密后的明文
     * @return          删除补位字符后的明文
     */
    private static byte[] decode(byte[] decrypted) {
        int pad = decrypted[decrypted.length - 1];
        if (pad < 1 || pad > 32) {
            pad = 0;
        }
        return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
    }

    /**
     * 将数字转化成 ASCII码 对应的字符，用于对明文进行补码
     *
     * @param amountToPad   需要转化的数字
     * @return              转化得到的字符
     */
    private static char charr(int amountToPad) {
        byte target = (byte) (amountToPad & 0xFF);
        return (char) target;
    }

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

    /**
     * 解密数据
     *
     * @param appId         小程序appId
     * @param encryptData   解密的目标密文
     * @param sessionKey    解密秘钥
     * @param iv            解密算法初始向量
     * @return
     */
    public static String decryptData(String appId, String encryptData, String sessionKey, String iv) {
        String result = "";
        byte[] resultByte = decrypt(
                Base64.decode(encryptData),
                Base64.decode(sessionKey),
                Base64.decode(iv));
        if (null != resultByte && resultByte.length > 0) {
            result = new String(decode(resultByte));
            JSONObject jsonObject = JSONObject.parseObject(result);
            String decryptAppid = jsonObject.getJSONObject("watermark").getString("appid");
            if (!appId.equals(decryptAppid)) {
                result = "";
            }
        }
        return result;
    }
}
