package com.example.newcoder01.dao;

import com.example.newcoder01.entity.Discuss_post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DiscussPostMapper {
    public List<Discuss_post> selectDiscussPostByUid(String user_id,int limit,int offset);
    public List<Discuss_post> selectDiscussPost(String userId,int limit,int offset);
    public int selectCount(String user_id);
    public List<Discuss_post> selectAll(int limit,int offset);
}
