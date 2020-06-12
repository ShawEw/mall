package com.imooc.mall.service;

import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/6/128:56 上午
 */
public interface IUserService {

    /**
     * 注册
     * @param user
     */
    ResponseVo<User> register(User user);

    ResponseVo<User> login(String username, String passward);
}
