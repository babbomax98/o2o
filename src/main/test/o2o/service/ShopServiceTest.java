package o2o.service;

import com.o2o.dto.ShopExecution;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.entity.ShopCategory;
import com.o2o.enums.ShopStateEnum;
import com.o2o.service.ShopService;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author shkstart
 * @create 2020-04-17 23:13
 */
public class ShopServiceTest extends BaseTest {

    @Autowired
    ShopService shopService;


    //出现nullNullPointerException
    @Test
    public void testGetShopList(){
        Shop shop = new Shop();
        ShopCategory sc=new ShopCategory();
        sc.setShopCategoryId(1);
        shop.setShopCategory(sc);
        ShopExecution se=shopService.getShopList(shop,1,2);
        System.out.println("店铺列表数"+se.getShopList().size());


    }

    @Test
    public void testModifyShop() throws Exception {
        Shop shop=shopService.getByShopId(1);
        shop.setShopId(1);
        shop.setShopName("s大苏打");
        File shopImg=new File("E:/image/item/headtitle/base.jpg");
        InputStream is=new FileInputStream(shopImg);
    //    ShopExecution shopExecution = shopService.modifyShop(shop, is, "base.jpg");
     //   System.out.println("新的图片地址为"+ shopExecution.getShop().getShopImg());
    }

    @Test
    public void testAddShop() throws FileNotFoundException {

        Shop shop = new Shop();

        PersonInfo owner = new PersonInfo();
      //  Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
      //  area.setAreaId(2);
        shopCategory.setShopCategoryId(1);

      //  shop.setOwner(owner);
      //  shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试de店铺4");
        shop.setShopDesc("店铺描述4");
        shop.setShopAddr("测试路4号1");
        shop.setPhone("1234567892");
        shop.setPriority(4);
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("E:/image/item/headtitle/base.jpg");
        InputStream is = new FileInputStream(shopImg);
  //      ShopExecution se= shopService.addShop(shop, is,shopImg.getName());
//        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());



    }
}
