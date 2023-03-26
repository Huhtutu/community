package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

/**
 *  持有用户信息,代替Session
 */
@Component
public class HostHolder {

    private ThreadLocal<User> users= new ThreadLocal<>();

    /**
     *  设置缓存数据
     * @param
     */
    public void setUser(User user){
        users.set(user);
    }

    /**
     *  获取缓存数据
     * @return
     */
    public User getUser(){
        return users.get();
    }

    /**
     *  清除缓存
     */
    public void clear(){
        users.remove();
    }
}
