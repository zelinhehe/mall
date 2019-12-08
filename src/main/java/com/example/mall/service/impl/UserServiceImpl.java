package com.example.mall.service.impl;

import com.example.mall.dao.UserMapper;
import com.example.mall.pojo.User;
import com.example.mall.service.IUserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements IUserService {  // cmd + i

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        // username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0) {
            throw new RuntimeException("该username已注册");
        }
        // email 不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0) {
            throw new RuntimeException("该email已注册");
        }

        // MD5摘要（Spring自带）
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));

        // 写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0) {
            throw new RuntimeException("注册失败");
        }
    }
}
