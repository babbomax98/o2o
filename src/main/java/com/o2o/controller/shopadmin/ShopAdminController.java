package com.o2o.controller.shopadmin;

import com.o2o.entity.Shop;
import com.o2o.utils.HttpServletRequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 重定向至前端写的页面
 * @create 2020-04-24 22:16
 */
@Controller
@RequestMapping(value = "/shopadmin")
public class ShopAdminController {
    @RequestMapping(value = "/test")
    public Map<String, Object> productcategory(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String kaptchaExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        System.out.println(kaptchaExpected);
        modelMap.put("verifyCode", kaptchaExpected);
        return modelMap;
    }

    @RequestMapping(value = "/ownerlogin")
    public String ownerLogin(HttpServletRequest request) {
        return "shop/ownerlogin";
    }

    //注册页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    private String register() {
        return "shop/register";
    }

    //修改密码
    @RequestMapping(value = "/changepsw", method = RequestMethod.GET)
    private String changePsw() {
        return "shop/changepsw";
    }


    //绑定微信
    @RequestMapping(value = "/ownerbind", method = RequestMethod.GET)
    private String ownerBind() {
        return "shop/ownerbind";
    }

    //商店列表
    @RequestMapping(value = "/shoplist", method = RequestMethod.GET)
    private String myList() {
        return "shop/shoplist";
    }


    @RequestMapping(value = "/shopmanage", method = RequestMethod.GET)
    private String shopManage(HttpServletRequest request) {
        int shopId = HttpServletRequestUtil.getInt(request, "shopId");
        if (shopId <= 0) {
            Object currentShopObj = request.getSession().getAttribute(
                    "currentShop");
            if (currentShopObj == null) {
                return "shop/shoplist";
            } else {
                return "shop/shopmanage";
            }
        } else {
            Shop currentShop = new Shop();
            currentShop.setShopId(shopId);
            request.getSession().setAttribute("currentShop", currentShop);
            return "shop/shopmanage";
        }
    }

    //商店信息
    @RequestMapping(value = "/shopedit", method = RequestMethod.GET)
    private String shopEdit() {
        return "shop/shopedit";
    }

    //商品管理
    @RequestMapping(value = "/productmanage", method = RequestMethod.GET)
    private String productManage() {
        return "shop/productmanage";
    }

    //商品编辑
    @RequestMapping(value = "/productedit", method = RequestMethod.GET)
    private String productEdit() {
        return "shop/productedit";
    }

    //商品分类管理
    @RequestMapping(value = "/productcategorymanage", method = RequestMethod.GET)
    private String productCategoryManage() {
        return "shop/productcategorymanage";
    }

    //权限管理
    @RequestMapping(value = "/shopauthmanage", method = RequestMethod.GET)
    private String shopAuthManage() {
        return "shop/shopauthmanage";
    }

    //权限编辑
    @RequestMapping(value = "/shopauthedit", method = RequestMethod.GET)
    private String shopAuthEdit() {
        return "shop/shopauthedit";
    }

    //消费记录
    @RequestMapping(value = "/productbuycheck", method = RequestMethod.GET)
    private String productBuyCheck() {
        return "shop/productbuycheck";
    }

    //积分记录
    @RequestMapping(value = "/awarddelivercheck", method = RequestMethod.GET)
    private String awardDeliverCheck() {
        return "shop/awarddelivercheck";
    }

    //用户列表
    @RequestMapping(value = "/usershopcheck", method = RequestMethod.GET)
    private String userShopCheck() {
        return "shop/usershopcheck";
    }

    //奖品管理
    @RequestMapping(value = "/awardmanage", method = RequestMethod.GET)
    private String awardManage() {
        return "shop/awardmanage";
    }

    //奖品编辑
    @RequestMapping(value = "/awardedit", method = RequestMethod.GET)
    private String awardEdit() {
        return "shop/awardedit";
    }

//    @RequestMapping(value = "/customermanage", method = RequestMethod.GET)
//    private String customerManage() {
//        return "shop/customermanage";
//    }


}
