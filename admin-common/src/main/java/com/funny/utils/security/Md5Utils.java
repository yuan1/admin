package com.funny.utils.security;


import org.springframework.util.DigestUtils;

/**
 * md5 消息摘要算法
 * @author funny
 *
 */
public class Md5Utils  {
    /**
     * md5加密
     * @param instr 需要加密的字符串
     * @return
     * funny
     * 2016年3月11日 下午12:24:37
     */
    public static String md5(String instr) {
        return DigestUtils.md5DigestAsHex(instr.getBytes());
    }

    public static void main(String[] args) throws Exception {
        String res = md5("111111");
        System.out.println(res + "||length =" + res.length());
    }
}
