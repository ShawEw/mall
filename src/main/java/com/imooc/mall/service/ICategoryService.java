package com.imooc.mall.service;

import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/8/204:52 下午
 */
public interface ICategoryService {

    ResponseVo<List<CategoryVo>> selectAll();

}
