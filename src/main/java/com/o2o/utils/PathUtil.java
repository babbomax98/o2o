package com.o2o.utils;

/**
 * @author shkstart
 * @create 2020-04-17 18:47
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    //根据不同的操作系统选择不同的根目录
    public static String getImgBasePath(){
        String os=System.getProperty("os.name");
        String basePath="";
        if (os.toLowerCase().startsWith("win")){
            basePath="E:/image/item/newimg";
        }else{
            basePath="/home/image/";
        }
        basePath=basePath.replace("/",seperator);
        return basePath;
    }

    //店铺图片存储路径
    public static String getShopImagePath(Integer shopId){
        String imagePath="E:/image/item/shopdoor";
        return imagePath.replace("/",seperator);
    }
}
