package com.example.newcoder01.service;

import com.example.newcoder01.entity.Discuss_post;

import java.util.List;

public interface IDiscussPostService {
    public List<Discuss_post> findByUid(String user_id,int limit,int offset);
    public List<Discuss_post> findDiscussPost(String userId,int limit,int offset);
    public List<Discuss_post> findAll(int limit,int offset);
    public int discussPostCount(String user_id);
}
