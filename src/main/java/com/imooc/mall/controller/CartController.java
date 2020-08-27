package com.imooc.mall.controller;

import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.enums.ProductStatus;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.pojo.Product;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.Normalizer;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/8/265:08 下午
 */
@RestController
public class CartController {

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm){
        Product product = productMapper.selectByPrimaryKey(cartAddForm.getProductId());
        if (product == null){
            return ResponseVo.error(ResponseEnum.PRODUCT_NOT_EXIST);
        }
        if (!product.getStatus().equals(ProductStatus.ON_SALE.getCode())){
            return ResponseVo.error(ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE);
        }
        if (product.getStock() <= 0){
            return ResponseVo.error(ResponseEnum.PRODUCT_STOCK_ERROR);
        }
        
        return null;
    }
}
