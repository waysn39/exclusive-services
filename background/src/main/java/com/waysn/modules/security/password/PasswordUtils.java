/**
 * Copyright (c) 2018 waysn All rights reserved.
 *
 *
 * 版权所有，侵权必究！
 */

package com.waysn.modules.security.password;

/**
 * 密码工具类
 *
 * @author jinyiming waysn39@hotmail.com
 * @since 1.0.0
 */
public class PasswordUtils {
    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 加密
     * @param str  字符串
     * @return     返回加密字符串
     */
    public static String encode(String str){
        return passwordEncoder.encode(str);
    }


    /**
     * 比较密码是否相等
     * @param str  明文密码
     * @param  password  加密后密码
     * @return     true：成功    false：失败
     */
    public static boolean matches(String str, String password){
        return passwordEncoder.matches(str, password);
    }


    public static void main(String[] args) {
        String str = "admin";
        String password = encode(str);

        System.out.println(password);
        System.out.println(matches(str, password));
    }

}
