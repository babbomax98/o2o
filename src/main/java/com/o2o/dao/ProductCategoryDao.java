package com.o2o.dao;

import com.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-24 22:47
 */
public interface ProductCategoryDao {
    /*
    * 通过shipid查询店铺商品类别
    *
    * */

    List<ProductCategory> queryProductCategoryList(int shopId);

    /*
    * 批量新增商品类别
    * */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /*
    * 删除指定商品类别
    *
    * */

    int deleteProductCategory(@Param("productCategoryId") int productCategoryId,
                              @Param("shopId") int shopId);

}
