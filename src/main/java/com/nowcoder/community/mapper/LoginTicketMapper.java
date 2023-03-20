package com.nowcoder.community.mapper;

import com.nowcoder.community.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginTicketMapper {

    @Insert({
            "insert into login_ticket(user_id,ticket,status,expired) ",
            "values(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "id")
    Integer insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "Select id,user_id,ticket,status,expired ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selecetByTicket(String ticket);

    @Update({
            "update login_ticket set status=#{status} where ticket=#{ticket} ",
    })
    Integer updateStatus(String ticket,Integer status);
}
