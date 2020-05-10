package com.o2o.service.impl;

import com.o2o.Exception.ShopOperationException;
import com.o2o.dao.ShopDao;
import com.o2o.dto.ImageHolder;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.Shop;
import com.o2o.enums.ShopStateEnum;
import com.o2o.service.ShopService;
import com.o2o.utils.ImageUtil;
import com.o2o.utils.PageCalculator;
import com.o2o.utils.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-17 22:31
 */
@Service
public class ShopServiceImpl implements ShopService {

    private Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);
    @Autowired
    private ShopDao shopDao;

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        int rowIndex= PageCalculator.calculateRowIndex(pageIndex,pageSize);
        List<Shop> shopList=shopDao.queryShopList(shopCondition,rowIndex,pageSize);
        int count=shopDao.queryShopCount(shopCondition);
        ShopExecution se=new ShopExecution();
        if (shopList!=null){
            se.setShopList(shopList);
            se.setCount(count);
        }else {
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return se;
    }

    @Override
    public Shop getByShopId(Integer shopId) {

        Shop shop = shopDao.queryByShopId(shopId);
        return shop;
    }

    @Override
    public ShopExecution modifyShop(Shop shop, ImageHolder thumnail) throws ShopOperationException {
        if (shop==null||shop.getShopId()==null) {
         return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }else {
            //1.判断是否需要处理图片
            try{
            if (thumnail.getImage()!=null&&thumnail.getImageName()!=null&&!"".equals(thumnail.getImageName())){
                Shop tempShop=shopDao.queryByShopId(shop.getShopId());
                if (tempShop.getShopImg()!=null){
                    ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                }
                addShopImage(shop,thumnail);
            }
            //2.更新店铺信息
            shop.setLastEditTime(new Date());
            int effectedNum=shopDao.updateshop(shop);
            if (effectedNum<=0){
                return new ShopExecution(ShopStateEnum.INNER_ERROR);
            }else {
                shop=shopDao.queryByShopId(shop.getShopId());
                return new ShopExecution(ShopStateEnum.SUCCESS,shop);
            }}catch (Exception e){
                throw new ShopOperationException("mode=ifyShop error:"+e.getMessage());
            }

        }

    }

    @Override
    public ShopExecution addShop(Shop shop, ImageHolder thumnail) {
        //空值判断
        if (shop==null){
            logger.warn("shop==null");
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            //给店铺信息赋予初值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum=shopDao.insertShop(shop);
            logger.warn("添加结果："+effectedNum+"shopId:"+shop.getShopId());
            if (effectedNum<=0){//判断此次插入是否有效
                throw new ShopOperationException("店铺创建失败");
            }else {
                if(thumnail.getImage() !=null){
                    //存储图片
                    try {
                        addShopImage(shop,thumnail);
                    }catch (Exception e){
                        throw new ShopOperationException("addShopImge error"+e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum=shopDao.updateshop(shop);
                    if (effectedNum<=0){
                        throw new ShopOperationException("更新图片地址失败");

                    }

                }

            }
        }catch (Exception e){
            throw new ShopOperationException("addShop error:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImage(Shop shop, ImageHolder thumnail) {
        // 获取shop图片目录的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(thumnail,dest);
        shop.setShopImg(shopImgAddr);
    }
}
