package com.imooc.mall.service.impl;

import com.imooc.mall.dao.UserMapper;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/6/128:58 上午
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0){
            throw  new RuntimeException("该username已注册");
        }
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0){
            throw  new RuntimeException("该email已注册");
        }
        //MD5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            throw new RuntimeException("注册失败");
        }
    }
}
