package com.o2o.service;

import com.o2o.Exception.ShopOperationException;
import com.o2o.dto.ImageHolder;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;


import java.io.InputStream;

/**
 * @author shkstart
 * @create 2020-04-17 22:30
 */
public interface ShopService {


    //根据ShopCondition分页实现
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    //通过店铺id获取店铺信息
    Shop getByShopId(Integer shopId);

    //更新店铺信息，包括对图片的处理
    ShopExecution modifyShop(Shop shop,ImageHolder thumnail) throws ShopOperationException;

    //增加店铺
    ShopExecution addShop(Shop shop, ImageHolder thumnail) throws ShopOperationException;
}
