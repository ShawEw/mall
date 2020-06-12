package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/6/125:00 下午
 */
@Data
public class UserLoginForm {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
