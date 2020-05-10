package com.o2o.service.impl;

import com.o2o.Exception.ProductCategoryOperationException;
import com.o2o.dao.ProductCategoryDao;
import com.o2o.dao.ProductDao;
import com.o2o.dto.ProductCategoryExecution;
import com.o2o.entity.ProductCategory;
import com.o2o.enums.ProductCategoryStateEnum;
import com.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author shkstart
 * @create 2020-04-24 23:09
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {


    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCategoryList(int shopId) {
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        return productCategoryList;
    }

    @Override
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException {
        if (productCategoryList!=null&&productCategoryList.size()>0){
            try {
                int effectedNum=productCategoryDao.batchInsertProductCategory(productCategoryList);
                if (effectedNum<=0){
                    throw new ProductCategoryOperationException("店铺创建失败");
                }else {
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
                }
            }catch (Exception e){
                throw new ProductCategoryOperationException("batchAddProductCategory error"+e.getMessage());

            }
        }else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }

    }

    @Override
    @Transactional//事务管理，因为有两个步骤，如果有某个步骤执行失败，则会回滚返回
    public ProductCategoryExecution deleteProductCategory(int productCategoryId, int shopId) {
        //1.将此商品类别下的商品类别id置为空

        try {
            int effectedNum=productDao.updateProductCategoryToNULL(productCategoryId);
            if (effectedNum<0){
                throw new ProductCategoryOperationException("商品类别更新失败");
            }
        }catch (Exception e){
            throw new ProductCategoryOperationException("deleteProductCategory error:"+e.getMessage());

        }
        //2.执行删除操作
        try{
            int effctedNum=productCategoryDao.deleteProductCategory(productCategoryId,shopId);
            if (effctedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败");
            }else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
            }catch (Exception e){
            throw new ProductCategoryOperationException("delectProductCategory error"+e.getMessage());

        }
        }
}
