package com.example.newcoder01.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaDaoMybatisImpl implements AlphaDao {
    @Override
    public String select() {
        System.out.println("执行了数据库层的方法...");
        return "Mybatis...";
    }
}
