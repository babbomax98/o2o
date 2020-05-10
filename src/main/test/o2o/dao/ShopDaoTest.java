package o2o.dao;

import com.o2o.dao.ShopDao;
import com.o2o.entity.Area;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author shkstart
 * @create 2020-04-16 22:29
 */
public class ShopDaoTest extends BaseTest {

    @Autowired
    private ShopDao shopDao;


    @Test
    public void testqueryShopList(){
        Shop shopCondition=new Shop();
        ShopCategory childCategory=new ShopCategory();
        ShopCategory parentCategory=new ShopCategory();
        parentCategory.setShopCategoryId(12);
        childCategory.setParent(parentCategory);
        shopCondition.setShopCategory(childCategory);
        PersonInfo owner=new PersonInfo();
        owner.setUserId(1L);
//        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 5);
        System.out.println("长度："+shopList.size());
    }


    @Test
    public void testQueryByShopId(){
        Integer shopId=1;
        Shop shop=shopDao.queryByShopId(shopId);
        System.out.println(shop);
    }

    @Test
    public void testInsertShop(){
        Shop shop = new Shop();
        shop.setOwnerId(1);
        shop.setAreaId(1);
        shop.setShopCategoryId(1);
        shop.setShopId(new Random().nextInt(10000));
        shop.setOwnerId(1);
        shop.setShopName("mytest1");
        shop.setShopDesc("mytest1");
        shop.setShopAddr("testaddr1");
        shop.setPhone("13810524526");
        shop.setShopImg("test1");
        shop.setPriority(8);
        shop.setCreateTime(new Date());
        shop.setEnableStatus(0);
        shop.setLastEditTime(new Date());
        shop.setAdvice("审核中");

        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);

    }
}
