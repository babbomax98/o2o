package com.o2o.controller.superadmin;

import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-04-16 21:58
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listArea(){
    Map<String,Object> modelMap=new HashMap<String,Object>();
    List<Area> list=new ArrayList<Area>();
    try{
        list=areaService.getAreaList();
        modelMap.put("rows",list);
        modelMap.put("total",list.size());
    }catch(Exception e){
        e.printStackTrace();
        modelMap.put("success",false);
        modelMap.put("errMsg",e.toString());

    }
    return modelMap;
    }
}
