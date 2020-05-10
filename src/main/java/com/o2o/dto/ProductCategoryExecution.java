package com.o2o.dto;

import com.o2o.entity.ProductCategory;
import com.o2o.enums.ProductCategoryStateEnum;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-25 22:38
 */
public class ProductCategoryExecution {

    //状态码
    private int state;

    //状态标识
    private String stateInfo;

    private List<ProductCategory> productCategoryList;

    private ProductCategoryExecution(){

    }

    //操作失败的时候使用的构造器
    private ProductCategoryExecution(int state, String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }

    //操作成功时候使用的构造器
    public ProductCategoryExecution(ProductCategoryStateEnum stateEnum, List<ProductCategory> productCategoryList){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.productCategoryList=productCategoryList;
    }

    //操作成功时候使用的构造器
    public ProductCategoryExecution(ProductCategoryStateEnum stateEnum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}