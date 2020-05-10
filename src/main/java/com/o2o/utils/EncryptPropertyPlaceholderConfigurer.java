package com.o2o.utils;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author shkstart
 * @create 2020-05-07 13:09
 */
public class EncryptPropertyPlaceholderConfigurer  extends
        PropertyPlaceholderConfigurer {
    //需要加密的字段数组
    private String[] encryptPropNames = { "jdbc.username", "jdbc.password" };


    /*
    * 对关键的属性进行转换
    * */
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            //对已加密的字段进行解密工作
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }

    /*
    * 该属性是否已加密
    * */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptpropertyName : encryptPropNames) {
            if (encryptpropertyName.equals(propertyName))
                return true;
        }
        return false;
    }
}
