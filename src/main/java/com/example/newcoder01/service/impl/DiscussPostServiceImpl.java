package com.example.newcoder01.service.impl;

import com.example.newcoder01.dao.DiscussPostMapper;
import com.example.newcoder01.entity.Discuss_post;
import com.example.newcoder01.service.IDiscussPostService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostServiceImpl implements IDiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Override
    public List<Discuss_post> findByUid(String user_id, int limit, int offset) {
        return discussPostMapper.selectDiscussPostByUid(user_id,limit,offset);
    }

    @Override
    public List<Discuss_post> findDiscussPost(String userId, int limit, int offset) {
        List<Discuss_post> list = discussPostMapper.selectDiscussPost(userId,limit,offset);
        return list;
    }

    @Override
    public List<Discuss_post> findAll(int limit, int offset) {
        List<Discuss_post> list = discussPostMapper.selectAll(limit,offset);
        return list;
    }

    @Override
    public int discussPostCount(String user_id) {
        return discussPostMapper.selectCount(user_id);
    }
}
