package com.o2o.dao;

import com.dyuproject.protostuff.LimitedInputStream;
import com.o2o.entity.Area;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-16 14:04
 */
public interface AreaDao {
    //列出区域列表
    List<Area> queryArea();
}
