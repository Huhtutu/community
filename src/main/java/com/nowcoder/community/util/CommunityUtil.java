package com.nowcoder.community.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
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

    //
    public static String getJsonStr(Integer code, String msg, Map<String,Object> map){
        JSONObject json = new JSONObject();
        json.put("code",code);
        json.put("msg",msg);
        if(map != null){
            for(String key : map.keySet()){
                json.put(key,map.get(key));
            }
        }
        return json.toJSONString();
    }

    public static String getJsonStr(Integer code, String msg){
        return getJsonStr(code,msg,null);
    }

    public static String getJsonStr(Integer code){
        return getJsonStr(code,null,null);
    }

    //测试Json
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("user","Hututu");
        map.put("emp","Leader");
        System.out.println(getJsonStr(1,"Success",map));
    }
}

