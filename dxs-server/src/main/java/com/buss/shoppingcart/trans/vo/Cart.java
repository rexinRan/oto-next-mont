package com.buss.shoppingcart.trans.vo;

import com.aliyun.openservices.oss.model.MultipartUploadListing;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jweb.core.bean.BaseVO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HongXinGuoJi-yzg on 2016/11/22.
 * 购物车对象
 */
public class Cart implements Serializable{

    // 购物项的结果集
    private List<ShoppingItme> shoppingItmes = new ArrayList<ShoppingItme>();

    // 加入购物项
    @JsonIgnore  // 不是pojo中完整的方法所以用@JsonIgnore
    public void addItem(ShoppingItme shoppingItme){
        // 判断购物车中是否包含添加时的购物项
        if (shoppingItmes.contains(shoppingItme)) {
            // 如果包含只增加该购物项的数量
            // 遍历购物车中所有的购物项
            for (ShoppingItme itme : shoppingItmes) {
                // 判断添加的购物项和遍历的购物项是否相等
                if (itme.equals(shoppingItme)) {
                    // 如果相等购物车中的该购物项的数量增加  原来的数量和添加的数量相加
                    itme.setNum(String.valueOf(Integer.parseInt(itme.getNum()) + Integer.parseInt(shoppingItme.getNum())));
                }
            }
        }else {
            // 否则购物车不包含该购物项,那么添加该购物项
            shoppingItmes.add(shoppingItme);
        }
    }

    //小计
    //商品数量
    @JsonIgnore
    public Integer getProductAmount(){
        Integer result = 0;
        //计算
        for (ShoppingItme item : shoppingItmes) {
            result += Integer.parseInt(item.getNum());
        }
        return result;
    }
    //商品金额
    @JsonIgnore
    public Float getProductPrice(){
        Float result = 0f;
        //计算
        for (ShoppingItme item : shoppingItmes) {
            BigDecimal bigDecimal = new BigDecimal(item.getNum());
            BigDecimal bigDecimal1 = new BigDecimal(item.getPrice());
            result += Float.valueOf(bigDecimal.multiply(bigDecimal1)+"");
        }
        return result;
    }
    //运费
    /*@JsonIgnore
    public Float getFee(){
        Float result = 0f;
        //计算
        if(getProductPrice() < 79){
            result = 5f;
        }
        return result;
    }*/

    //总价
    @JsonIgnore
    public Float getTotalPrice(){
        return getProductPrice();
    }



    public List<ShoppingItme> getShoppingItmes() {
        return shoppingItmes;
    }

    public void setShoppingItmes(List<ShoppingItme> shoppingItmes) {
        this.shoppingItmes = shoppingItmes;
    }
}
