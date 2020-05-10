package com.o2o.dao;

import com.o2o.entity.Product;
import com.o2o.entity.ProductImg;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-28 19:03
 */
public interface ProductImgDao {

    List<ProductImg> queryProductImgList(long productId);


    /*
    * 批量添加商品详情图片
    * */
    int batchInsertProductImg(List<ProductImg> productImgList);
    /*
    * 删除指定商品下的所有详情图
    * */
    int deleteProductImgByProductId(int ProductId);
}
