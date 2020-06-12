package com.imooc.mall.service.impl;

import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/6/1211:13 上午
 */
@SpringBootTest
@Transactional
class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Test
    void register() {
        User user = new User();
        user.setUsername("jack");
        user.setPassword("123456");
        user.setEmail("jack@qq.com");
        user.setRole(RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }
}