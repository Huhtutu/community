package com.nowcoder.community.util;

import lombok.Data;

/**
 *  分页工具类
 */
@Data
public class PageInfo {

    //当前页码
    private Integer current = 1;
    //每页记录数
    private Integer limit = 10;
    //总记录数
    private Integer rows;
    //查询路径(分页链接)
    private String path;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if (current >= 1){
            this.current = current;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit >=1 && limit <=100){
            this.limit = limit;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        if (rows >= 0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     *  获取当前页的起始行数
     * @return
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     *  总页数
     * @return
     */
    public int getTotal(){
        return (rows % limit == 0) ? (rows / limit) : (rows / limit+1);
    }

    /**
     *  获取起始页码
     * @return
     */
    public int getFrom(){
        int from = current -2;
        return from < 1 ? 1 : from;
    }

    /**
     *  获取终止页码
     * @return
     */
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
