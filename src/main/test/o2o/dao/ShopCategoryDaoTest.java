package o2o.dao;

import com.o2o.dao.ShopCategoryDao;
import com.o2o.entity.ShopCategory;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author shkstart
 * @create 2020-04-22 17:29
 */
public class ShopCategoryDaoTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory(){
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(new ShopCategory());
//        assertEquals(1,shopCategoryList.size());
//        System.out.println(shopCategoryList);
        ShopCategory testCategory=new ShopCategory();
        ShopCategory parentCategory=new ShopCategory();
        parentCategory.setShopCategoryId(1);
        testCategory.setParent(parentCategory);
        shopCategoryList = shopCategoryDao.queryShopCategory(testCategory);

    }


}
