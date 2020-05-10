package com.o2o.service;

import com.o2o.Exception.ProductCategoryOperationException;
import com.o2o.dto.ProductCategoryExecution;
import com.o2o.entity.ProductCategory;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-24 22:55
 */
public interface ProductCategoryService {

    /*
    * 查询制定某个店铺下的所有商品类别信息
    *
    * */
    List<ProductCategory> getProductCategoryList(int shopId);

    /*
     * 批量新增商品类别
     * */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
    /*
    * 将此类别下的商品id置为空，再删除指定的商品类别,并
    * */

    ProductCategoryExecution deleteProductCategory(int productCategoryId,int shopId);
}
