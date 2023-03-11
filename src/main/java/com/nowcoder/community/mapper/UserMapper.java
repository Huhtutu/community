package com.nowcoder.community.mapper;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

    /**
     *
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     *
     * @param username
     * @return
     */
    User selectByName(String username);

    /**
     *
     * @param email
     * @return
     */
    User selectByEmail(String email);

    /**
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(Integer id,Integer status);

    /**
     *
     * @param id
     * @param headerUrl
     * @return
     */
    int updateHeader(Integer id,String headerUrl);

    /**
     *
     * @param id
     * @param password
     * @return
     */
    int updatePassword(Integer id,String password);

}
