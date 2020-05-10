package com.o2o.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.Exception.AreaOperationException;
import com.o2o.dao.AreaDao;
import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-16 18:29
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;
/*
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static String AREALISTKEY="arealist";
*/


    @Override
    @Transactional
    public List<Area> getAreaList() {

        return areaDao.queryArea();
     /*   // key
        String key = AREALISTKEY;
        List<Area> areaList = null;
        ObjectMapper mapper = new ObjectMapper();
        // 如果Redis中未存在key
        if (!jedisKeys.exists(key)) {
            // 数据库中获取区域列表
            areaList = areaDao.queryArea();
            String jsonString = null;
            // 将list转换为String
            try {
                jsonString = mapper.writeValueAsString(areaList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new AreaOperationException(e.getMessage());
            }
            jedisStrings.set(key, jsonString);
        }
        // Redis中存在key，则取出
        else {
            // 将String转换为List
            String jsonString = jedisStrings.get(key);
            JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);
            try {
                areaList = mapper.readValue(jsonString, javaType);
            } catch (JsonParseException e) {
                e.printStackTrace();
                throw new AreaOperationException(e.getMessage());
            } catch (JsonMappingException e) {
                e.printStackTrace();
                throw new AreaOperationException(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                throw new AreaOperationException(e.getMessage());
            }
        }

        return areaList;*/
    }
}
