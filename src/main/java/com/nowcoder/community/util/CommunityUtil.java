package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 *  常用工具类
 */
public class CommunityUtil {

    //生成随机字符串
    public static String genertUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5 密码加密
    public static String MD5(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}

