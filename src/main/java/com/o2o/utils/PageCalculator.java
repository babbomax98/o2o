package com.o2o.utils;

/**
 * @author shkstart
 * @create 2020-04-24 16:23
 */
public class PageCalculator {
    public static  int calculateRowIndex(int pageIndex,int pageSize){
        return (pageIndex>0)?(pageIndex-1)*pageSize:0;

    }
}
