package com.o2o.service;

import com.o2o.Exception.ProductOperationException;
import com.o2o.dto.ImageHolder;
import com.o2o.dto.ProductExecution;
import com.o2o.entity.Product;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.annotations.Param;

import java.io.InputStream;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-28 20:00
 */
public interface ProductService {


    /*
     * 查寻商品列表并分页，可输入的条件有：商品名（模糊）。商品状态,店铺ID，商品类别
     * */

    ProductExecution getProductList(Product productCondition,
                                   int pageIndex,
                                   int pageSize);


    /*
    *通过商品Id查询唯一的商品信息
    * */
    Product getProductById(int productId);

    /*
    * 添加商品信息以及图片处理
    * */
    ProductExecution addProduct(Product product, ImageHolder thumnail,
                               List<ImageHolder> productImgList)
            throws ProductOperationException;
    /*
    * 修改商品信息以及图片处理
    * */

    ProductExecution modifyProduct(Product product,ImageHolder thumbnail,List<ImageHolder> productImgHolderList)
        throws ProductOperationException;


}
