package o2o.dao;

import com.o2o.dao.ProductDao;
import com.o2o.dao.ProductImgDao;
import com.o2o.entity.Product;
import com.o2o.entity.ProductCategory;
import com.o2o.entity.ProductImg;
import com.o2o.entity.Shop;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-28 19:24
 */
public class ProductDaoTest extends BaseTest {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;


    @Test
    public void testAInsertProduct() throws Exception {
        Shop shop1 = new Shop();
        shop1.setShopId(1);
        Shop shop2 = new Shop();
        shop2.setShopId(2);
        ProductCategory pc1 = new ProductCategory();
        pc1.setProductCategoryId(2);
        ProductCategory pc2 = new ProductCategory();
        pc2.setProductCategoryId(3);
        ProductCategory pc3 = new ProductCategory();
        pc3.setProductCategoryId(4);
        Product product1 = new Product();
        product1.setProductName("测试1");
        product1.setProductDesc("测试Desc1");
        product1.setImgAddr("test1");
        product1.setPriority(0);
        product1.setEnableStatus(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setShop(shop1);
        product1.setProductCategory(pc1);
        Product product2 = new Product();
        product2.setProductName("测试2");
        product2.setProductDesc("测试Desc2");
        product2.setImgAddr("test2");
        product2.setPriority(0);
        product2.setEnableStatus(0);
        product2.setCreateTime(new Date());
        product2.setLastEditTime(new Date());
        product2.setShop(shop1);
        product2.setProductCategory(pc2);
        Product product3 = new Product();
        product3.setProductName("测试3");
        product3.setProductDesc("测试Desc3");
        product3.setImgAddr("test3");
        product3.setPriority(0);
        product3.setEnableStatus(1);
        product3.setCreateTime(new Date());
        product3.setLastEditTime(new Date());
        product3.setShop(shop2);
        product3.setProductCategory(pc3);
        int effectedNum = productDao.insertProduct(product1);
        effectedNum = productDao.insertProduct(product2);
        effectedNum = productDao.insertProduct(product3);
    }

    @Test
    public void testCQueryProductByProductId() throws Exception {
        int productId = 1;
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);
        productImg1.setCreateTime(new Date());
        productImg1.setProductId(productId);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(productId);
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectedNum = productImgDao.batchInsertProductImg(productImgList);
        Product product = productDao.queryProductByProductId(productId);
        effectedNum = productImgDao.deleteProductImgByProductId(productId);
    }
    @Test
    public void testBQueryProductList() throws Exception {
        Product product = new Product();
        List<Product> productList = productDao.queryProductList(product, 0, 3);
        int count = productDao.queryProductCount(product);
        product.setProductName("wd");
        productList = productDao.queryProductList(product, 0, 3);
        count = productDao.queryProductCount(product);
        Shop shop = new Shop();
        shop.setShopId(1);
        product.setShop(shop);
        productList = productDao.queryProductList(product, 0, 3);
        count = productDao.queryProductCount(product);
    }




}
