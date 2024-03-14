package com.study.library.repository;

import com.study.library.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User findUserByUsername(String username);
    public int savaUser(User user);
    public int saveRole(int userId);
}
