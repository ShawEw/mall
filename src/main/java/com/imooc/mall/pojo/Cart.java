package com.imooc.mall.pojo;

import lombok.Data;

/**
 * Description: <br/>
 * date: 2020-11-25 21:52<br/>
 *
 * @author jh.jiang<br />
 */
@Data
public class Cart {

    private Integer productId;

    private Integer quantity;

    private Boolean productSelected;

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }

    public Cart() {
    }
}
