package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DiscussPost {

    private int id;
    /**
     * 用户ID
     */

    private int userId;
    /**
     * 帖子标题
     * 存储数据使用ik_max_word分词器，检索数据使用ik_smart分词器
     */

    private String title;
    /**
     * 帖子内容
     */

    private String content;
    /**
     * 帖子类型
     *  0-普通; 1-置顶;
     */

    private int type;
    /**
     * 帖子状态
     *  0-正常; 1-精华; 2-拉黑/删除;
     */

    private int status;

    private Date createTime;
    /**
     * 帖子评论数
     */
    private int commentCount;
    /**
     * 帖子分数
     */
    private double score;
}
