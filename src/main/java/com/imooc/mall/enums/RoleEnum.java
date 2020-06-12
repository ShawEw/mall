package com.imooc.mall.enums;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/6/1211:25 上午
 */
public enum RoleEnum {
    ADMIN(0),

    CUSTOMER(1),
            ;

    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
