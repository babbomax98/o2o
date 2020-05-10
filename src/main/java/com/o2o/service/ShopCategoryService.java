package com.o2o.service;

import com.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-22 17:55
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
