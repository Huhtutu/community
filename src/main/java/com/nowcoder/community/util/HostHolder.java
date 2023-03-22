package com.nowcoder.community.util;

import com.nowcoder.community.entity.User;
import org.springframework.stereotype.Component;

/**
 *  持有用户信息,代替Session
 */
@Component
public class HostHolder<T> {

    private ThreadLocal<T> users= new ThreadLocal<>();

    /**
     *  设置缓存数据
     * @param t
     */
    public void setUser(T t){
        users.set(t);
    }

    /**
     *  获取缓存数据
     * @return
     */
    public T getUser(){
        return users.get();
    }

    /**
     *  清除缓存
     */
    public void clear(){
        users.remove();
    }
}
