package com.imooc.mall.enums;

import lombok.Getter;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/6/122:48 下午
 */
@Getter
public enum ResponseEnum {

    ERROR(-1, "服务端错误"),

    SUCCESS(0, "成功"),

    PASSWORD_ERROR(1,"密码错误"),

    USERNAME_EXIST(2,"用户名已存在"),

    PARAM_ERROR(3, "参数错误"),

    EMAIL_EXIST(4,"邮箱已存在"),

    NEED_LOGIN(10, "用户未登录，请先登录"),

    USERNAME_OR_PASSWORD_ERROR(11, "用户名或密码错误"),

    PRODUCT_OFF_SALE_OR_DELETE(12, "商品已下架或已删除"),

    PRODUCT_NOT_EXIST(13, "商品不存在"),

    PRODUCT_STOCK_ERROR(14, "库存不正确"),

    CART_PRODUCT_NOT_EXIST(15, "购物车里商品不存在"),

    DELETE_SHIPPING_FAIL(16, "删除地址失败"),

    ;

     Integer code;
     String description;

    ResponseEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
