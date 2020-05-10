package com.o2o.dao;

import com.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-16 22:19
 */
public interface ShopDao {

    /*
    * 通过分页查询店铺
    * 可输入的条件有：店铺名（模糊查询）
    * 店铺状态
    * 店铺类别
    * 区域ID
    * owner
    *
    * rowIndex：表示从第几行开始取数据
    * PageSize：表示返回多少行数据
    * */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,
                             @Param("rowIndex") int rowIndex,
                             @Param("pageSize") int pageSize);

    //返回queryShopList总数
    int queryShopCount(@Param("shopCondition") Shop shopCondition);
    //通过shopId查询店铺
    Shop queryByShopId(Integer shopId);
    //新增店铺
    int insertShop(Shop shop);
    //更新店铺
    int updateshop(Shop shop);
}
