package com.nowcoder.community.mapper;


import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(Integer userId, Integer offset, Integer limit);

    //@Param 给参数取别名,
    // 如果该方法只有一个参数,并且在<if>里使用(动态SQL),则必须加别名
    Integer selectDiscussPostRows(@Param("userId") Integer userId);


}
