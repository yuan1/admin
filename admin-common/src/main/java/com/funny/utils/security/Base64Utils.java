package com.funny.utils.security;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * Base64 加密解密
 * @author funny
 *      <dependency>
 *           <groupId>commons-codec</groupId>
 *          <artifactId>commons-codec</artifactId>
 *           <version>1.10</version>
 *       </dependency>
 */
@SuppressWarnings("restriction")
public class Base64Utils {
    /**
     * base64 加密
     * @param src 需要加密的字符串
     * @return
     * funny
     * 2016年3月11日 下午2:00:45
     */
    public static String encode(String src) {
        return commonsBase64Encode(src);
    }
    public static String encode(byte[] bytes) {
        return commonsBase64Encode(bytes);
    }
    /**
     * base64 解密
     * @param encodestr 需要解密的字符串
     * @return
     * funny
     * 2016年3月11日 下午2:01:05
     */
    public static String decode(String encodestr) {
        return commonsBase64Decode(encodestr);
    }



    public static String jdkBase64Encode(String src) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(src.getBytes());
    }

    public static String jdkBase64Encode(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    public static String jdkBase64Decode(String src) {
        BASE64Decoder decoder = new BASE64Decoder();
        String res = null;
        try {
            res= new String(decoder.decodeBuffer(src));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }
    
    public static String commonsBase64Encode(String src) {
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        return new String(encodeBytes);
    }

    public static String commonsBase64Decode(String encodestr) {
        byte[] decodeBytes = Base64.decodeBase64(encodestr.getBytes());
        return new String(decodeBytes);
    }

    public static String commonsBase64Encode(byte[] bytes) {
        byte[] encodeBytes = Base64.encodeBase64(bytes);
        return new String(encodeBytes);
    }

}
