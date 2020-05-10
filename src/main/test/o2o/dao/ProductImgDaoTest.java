package o2o.dao;

import com.o2o.dao.ProductImgDao;
import com.o2o.entity.ProductImg;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-28 19:25
 */
public class ProductImgDaoTest extends BaseTest {

    @Autowired
    private   ProductImgDao productImgDao;


    @Test
    public void testBatchInsertProductImg(){
        ProductImg productImg1 = new ProductImg();
        productImg1.setImgAddr("图片1");
        productImg1.setImgDesc("测试图片1");
        productImg1.setPriority(1);

        productImg1.setCreateTime(new Date());
        productImg1.setProductId(1);
        ProductImg productImg2 = new ProductImg();
        productImg2.setImgAddr("图片2");
        productImg2.setPriority(1);
        productImg2.setCreateTime(new Date());
        productImg2.setProductId(1);
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        productImgList.add(productImg1);
        productImgList.add(productImg2);
        int effectedNum = productImgDao.batchInsertProductImg(productImgList);

    }
    @Test
    public void testCDeleteProductImgByProductId() throws Exception {
        int productId = 1;
        int effectedNum = productImgDao.deleteProductImgByProductId(productId);
    }
}
