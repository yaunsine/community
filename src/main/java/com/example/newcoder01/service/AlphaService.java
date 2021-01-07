package com.example.newcoder01.service;

import com.example.newcoder01.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope("prototype")
public class AlphaService {
    @Autowired
    @Qualifier("alphaDaoMybatisImpl")
    private AlphaDao alphaDao;

    public AlphaService(){
        System.out.println("构造方法，实例化service");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化service");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁service");
    }
    public String executeSelect(){
        System.out.println("执行了业务层方法...");
        return alphaDao.select();

    }
}
