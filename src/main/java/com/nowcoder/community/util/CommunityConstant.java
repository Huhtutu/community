package com.nowcoder.community.util;

public interface CommunityConstant {
    /**
     * 激活成功
     */
    Integer ACTIVATION_SUCCESS = 0;
    /**
     * 激活成功
     */
    Integer ACTIVATION_REPEAT = 1;
    /**
     * 激活成功
     */
    Integer ACTIVATION_FAILURE = 2;
    /**
     *  默认状态的登录凭证超时时间
     */
    Integer DEFAULT_EXPIRED_SECONDS = 3600 * 12;
    /**
     *  记住状态下的登录凭证超时时间
     */
    Integer REMEMBER_EXPIRED_SECONDS = 3600 * 12 * 7;
}
