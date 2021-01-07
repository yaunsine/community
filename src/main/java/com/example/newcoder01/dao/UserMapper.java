package com.example.newcoder01.dao;

import com.example.newcoder01.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    public User selectById(Integer id);
    public List<User> selectByName(String username);
    public int insertUser(User user);
    public int updatePassword(Integer id,String password);
}
