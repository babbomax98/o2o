package com.o2o.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author shkstart
 * @create 2020-05-01 22:01
 */
@Controller
@RequestMapping("/frontend")
public class FrontendController {


    //商品详情
    @RequestMapping(value = "/productdetail", method = RequestMethod.GET)
    private String showProductDetail() {
        return "frontend/productdetail";
    }

    //店铺详情
    @RequestMapping(value = "/shopdetail", method = RequestMethod.GET)
    private String showShopDetail() {
        return "frontend/shopdetail";
    }

    //商品列表
    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
    private String showShopList() {
        return "frontend/shoplist";
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    private String index() {
        return "frontend/index";
    }

    //积分店铺列表
    @RequestMapping(value = "/mypoint", method = RequestMethod.GET)
    private String myPoint() {
        return "frontend/mypoint";
    }

    //消费记录
    @RequestMapping(value = "/myrecord", method = RequestMethod.GET)
    private String myRecord() {
        return "frontend/myrecord";
    }

    //积分消费记录
    @RequestMapping(value = "/pointrecord", method = RequestMethod.GET)
    private String pointRecord() {
        return "frontend/pointrecord";
    }

    //微信绑定
    @RequestMapping(value = "/customerbind", method = RequestMethod.GET)
    private String customerBind() {
        return "frontend/customerbind";
    }
}
