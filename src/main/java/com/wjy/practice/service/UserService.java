package com.wjy.practice.service;

import com.wjy.practice.domain.User;
import com.wjy.practice.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public Integer insertUser (User user) {
        User person = new User();
        if (ObjectUtils.isEmpty(user.getId())) {
            int insert = userMapper.insert(user);
            return insert;
        }else {
            int update = userMapper.updateByPrimaryKey(user);
            return update;
        }
    }

    public User selectUserById (Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
