package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/8/255:21 下午
 */
@Data
public class ProductVo {

    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private BigDecimal price;

    private Integer status;
}
