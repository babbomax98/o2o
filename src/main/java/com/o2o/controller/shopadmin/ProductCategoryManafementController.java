package com.o2o.controller.shopadmin;

import com.o2o.Exception.ProductCategoryOperationException;
import com.o2o.dto.ProductCategoryExecution;
import com.o2o.dto.Result;
import com.o2o.entity.ProductCategory;
import com.o2o.entity.Shop;
import com.o2o.enums.ProductCategoryStateEnum;
import com.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.ModalityListener;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-04-24 23:22
 */
@Controller
@RequestMapping("/shopadmin")
public class ProductCategoryManafementController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/getproductcategorylist",method = RequestMethod.GET)
    @ResponseBody
    private Result<List<ProductCategory>> getProductCategory(HttpServletRequest request){

        Shop currentShop=(Shop)request.getSession().getAttribute("currentShop");
        List<ProductCategory> list=null;

        if (currentShop!=null&&currentShop.getShopId()>0){
            list=productCategoryService.getProductCategoryList(currentShop.getShopId());
            return new Result<List<ProductCategory>>(true,list);
        }else {
            ProductCategoryStateEnum ps= ProductCategoryStateEnum.INNER_ERROR;
            return new Result<List<ProductCategory>>(false,ps.getState(),ps.getStateInfo());
        }

    }

    @RequestMapping(value = "/addproductcategory",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> addProductCategory(@RequestBody List<ProductCategory> productCategoryList,
                                                  HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Shop currentShop=(Shop)request.getSession().getAttribute("currentShop");
        for (ProductCategory pc:productCategoryList){
            pc.setShopId(currentShop.getShopId());
        }
        if (productCategoryList!=null&&productCategoryList.size()>0){
            try {
                ProductCategoryExecution pe=productCategoryService.batchAddProductCategory(productCategoryList);
                if (pe.getState()==ProductCategoryStateEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                }else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg", pe.getStateInfo());
                }
            }catch (ProductCategoryOperationException e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.toString());
                return modelMap;
            }
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请至少输入一个商品类别");
        }
        return modelMap;
    }

    @RequestMapping(value = "/removeproductcategory",method = RequestMethod.POST)
    @ResponseBody
    private  Map<String,Object> removeProductCategory(int productCategoryId,HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        if(productCategoryId>0){
            try {
                Shop currentShop=(Shop)request.getSession().getAttribute("currentShop");
                ProductCategoryExecution pe=productCategoryService.deleteProductCategory(productCategoryId,
                        currentShop.getShopId());
                if (pe.getState()==ProductCategoryStateEnum.SUCCESS.getState()){
                    modelMap.put("success",true);
                }else {
                    modelMap.put("success",false);
                    modelMap.put("errMsg",pe.getStateInfo());
                }
            }catch (ProductCategoryOperationException e){
                modelMap.put("success",false);
                modelMap.put("errMsh",e.toString());
                return modelMap;
            }
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请至少选择一个商品类别");
        }
        return modelMap;
    }
}
