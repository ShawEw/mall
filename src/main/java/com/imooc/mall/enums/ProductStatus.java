package com.imooc.mall.enums;

import lombok.Getter;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/8/262:12 下午
 */
@Getter
public enum ProductStatus {

    ON_SALE(1),

    OFF_SALE(2),

    DELETE(3),
    ;

    Integer code;

    ProductStatus(Integer code) {
        this.code = code;
    }
}
