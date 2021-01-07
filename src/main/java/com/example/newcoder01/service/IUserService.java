package com.example.newcoder01.service;

import com.example.newcoder01.entity.User;

import java.util.List;

public interface IUserService {
    public User findById(Integer id);
    public int addItem(User user);
    public List<User> findByName(String name);
    public int updatePassword(Integer id,String password);
}
