package com.o2o.service;

import com.o2o.entity.HeadLine;

import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-30 10:28
 */
public interface HeadLineService {
    /*
    * 根据传入的条件返回指定的头条列表
    * */
    List<HeadLine> getHeadLineList(HeadLine headlineCondition) throws IOException;

}
