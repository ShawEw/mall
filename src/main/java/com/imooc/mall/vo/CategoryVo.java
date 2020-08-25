package com.imooc.mall.vo;

import lombok.Data;

import java.util.List;

/**
 * @author jiangjunhui
 * @description
 * @date 2020/8/204:51 下午
 */
@Data
public class CategoryVo {

    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private List<CategoryVo> subCategories;
}
