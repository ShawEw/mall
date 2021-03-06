package com.imooc.mall.controller;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.imooc.mall.enums.ResponseEnum.*;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/6/122:06 下午
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    @ResponseBody
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userRegisterForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("注册提交信息有误,{} {}", bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }

        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }

        ResponseVo<User> responseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        session.setAttribute(MallConst.CURRENT_USER, responseVo.getData());
        log.info("/login sessionId={}", session.getId());
        return responseVo;
    }

    //session 保存在内存中 改进版 token + redis
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        log.info("/login sessionId={}", session.getId());
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    /**
     * {@link org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory} getSessionTimeoutInMinutes
     */
    public ResponseVo logout(HttpSession session){
        log.info("/user/logout sessionId={}",session.getId());
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }

}
