package com.example.newcoder01.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AlphaHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
