package com.o2o.dao;

import com.o2o.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-28 19:02
 */
public interface ProductDao {


    /*
    * 删除商品类别之前，将商品类别ID置为空
    * */
    int updateProductCategoryToNULL(int productCategoryId);

    /*
    * 查寻商品列表并分页，可输入的条件有：商品名（模糊）。商品状态,店铺ID，商品类别
    * */

    List<Product> queryProductList(@Param("productCondition")Product productCondition,
                                   @Param("rowIndex")int rowIndex,
                                   @Param("pageSize")int pageSize);

    /*
    * 查询对应的商品数
    * */
    int queryProductCount(@Param("productCondition")Product productCondition);

    /*
    *通过productId查询唯一的商品信息
    * */
    Product queryProductByProductId(int productId);
    /*
    * 更新商品信息
    * */
    int updateProduct(Product product);


    /*
    * 插入商品
    * */
    int insertProduct(Product product);

}
