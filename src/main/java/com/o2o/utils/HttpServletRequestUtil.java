package com.o2o.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shkstart
 * @create 2020-04-18 17:30
 */
public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request,String key){
        try {
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request,String key){
        try {
            return Long.decode(request.getParameter(key));
        }catch (Exception e){
            return -1L;
        }
    }

    public static double getDouble(HttpServletRequest request,String key){
        try {
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1D;
        }
    }

    public static boolean getBoolean(HttpServletRequest request,String key){
        try {
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }

    //将request对应的键位值转换成String类型
    public static String getString(HttpServletRequest request,String key){
        try {
            String result=request.getParameter(key);
            if (result!=null){
                result=result.trim();
            }
            if ("".equals(result)){
                result=null;
            }
            return result;
        }catch (Exception e){
            return null;

        }
    }
}
