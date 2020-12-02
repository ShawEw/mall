package com.imooc.mall.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.form.CartUpdateForm;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * Description: <br/>
 * date: 2020-11-25 21:57<br/>
 *
 * @author jh.jiang<br />
 */
@SpringBootTest
@Slf4j
class CartServiceImplTest{

    @Autowired
    private ICartService cartService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    void add() {
        CartAddForm cartAddForm = new CartAddForm();
        cartAddForm.setProductId(27);
        cartAddForm.setSelected(true);
        cartService.add(1, cartAddForm);
    }

    @Test
    public void list(){
        ResponseVo<CartVo> list = cartService.list(1);
        log.info("list={}", gson.toJson(list));
    }

    @Test
    public void update() {
        CartUpdateForm cartUpdateForm = new CartUpdateForm();
        cartUpdateForm.setQuantity(5);
        cartUpdateForm.setSelected(false);
        ResponseVo<CartVo> list = cartService.update(1, 26, cartUpdateForm);
        log.info("result={}", gson.toJson(list));
    }

    @Test
    public void delete() {
        ResponseVo<CartVo> list = cartService.delete(1, 27);
        log.info("result={}", gson.toJson(list));
    }
}