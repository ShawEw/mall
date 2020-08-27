package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/8/264:55 下午
 */
@Data
public class CartProductVo {

    private Integer productId;

    private Integer quantity;

    private String productName;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;

    private BigDecimal productTotalPrice;

    private Integer productStock;

    private Boolean productSelected;

}
