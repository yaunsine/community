package com.example.newcoder01.entity;

public class Page {
    //当前页
    private int current = 1;
    //显示上限
    private int limit = 5;
    //数据总数，计算总页数
    private int rows;
    //链接页的路径，查询路径
    private String path = "/index";

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1)
            this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >=1 && limit <= 100)
            this.limit = limit;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0)
            this.rows = rows;
    }

    /**
     * @Author ayuan
     * @Description //TODO 获取起始行
     **/
    public int getOffset(){
        return (current-1)*limit;
    }

    /**
     * @Author ayuan
     * @Description //TODO 获取总页数
     **/
    public int getTotal() {
        if(rows % limit == 0)
            return rows/limit;
        else
            return rows/limit+1;
    }
    /**
     * @Author ayuan
     * @Description //TODO 获取起始页
     **/
    public int getFrom(){
        int from = current - 2;
        return from < 1 ? 1 : from;
    }
    /**
     * @Author ayuan
     * @Description //TODO 获取结束页
     **/
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }
}
