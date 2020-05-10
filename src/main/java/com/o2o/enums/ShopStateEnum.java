package com.o2o.enums;

/**
 * @author shkstart
 * @create 2020-04-10 22:56
 */
public enum ShopStateEnum {
    CHECK(0,"审核中"),OFFlINE(-1,"非法商铺"),SUCCESS(1,"操作成功")
    ,PASS(2,"通过认证"),INNER_ERROR(-1001,"内部系统错误"),
    NULL_SHOPID(-1002,"ShopId为空"),NULL_SHOP(-1003,"Shop信息为空");


    private int state;
    private String stateInfo;

    private ShopStateEnum(int state, String stateInfo){
        this.state=state;
        this.stateInfo=stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    //依据传入的state返回相应的enum值
    public static ShopStateEnum stateOf(int index){
        for (ShopStateEnum stateEnum:values()){
            if (stateEnum.getState()==index){
                return stateEnum;
            }
        }
        return null;
    }
}
