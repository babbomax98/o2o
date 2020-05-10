package o2o.dao;

import com.o2o.dao.ProductCategoryDao;
import com.o2o.entity.Product;
import com.o2o.entity.ProductCategory;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author shkstart
 * @create 2020-04-24 23:00
 */

public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryByShopId() throws Exception{
        int shopId=1;
        List<ProductCategory> productCategoryList=
                productCategoryDao.queryProductCategoryList(shopId);
        System.out.println(productCategoryList);
    }

    @Test
    public void testBatchInsertProductCategory(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setProductCategoryName("shangpin1");
        productCategory.setPriority(1);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(1);
        ProductCategory productCategory2=new ProductCategory();
        productCategory2.setProductCategoryName("shangpin2");
        productCategory2.setPriority(2);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(2);
        List<ProductCategory> productCategoryList=new ArrayList<ProductCategory>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);

        int effectedNum=productCategoryDao.batchInsertProductCategory(productCategoryList);
        //assertEquals(2,effectedNum);
    }
}
