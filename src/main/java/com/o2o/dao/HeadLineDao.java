package com.o2o.dao;

import com.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-30 10:03
 */
public interface HeadLineDao {

    /*
    * 根据传入的查询条件（头条名查询头条）
    * */
    List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);



}
