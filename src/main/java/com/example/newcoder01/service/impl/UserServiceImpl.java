package com.example.newcoder01.service.impl;

import com.example.newcoder01.dao.UserMapper;
import com.example.newcoder01.entity.User;
import com.example.newcoder01.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Integer id) {

        return userMapper.selectById(id);
    }

    @Override
    public int addItem(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public int updatePassword(Integer id, String password) {
        return userMapper.updatePassword(id,password);
    }
}
