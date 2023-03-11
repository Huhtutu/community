package com.nowcoder.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 */

@SpringBootApplication
@MapperScan("com.nowcoder.community.mapper")
public class CommunityApplication
{
    public static void main( String[] args )
    {

        SpringApplication.run(CommunityApplication.class);
    }
}
