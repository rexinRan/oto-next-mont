package com.buss.shoppingcart.trans.vo;

import java.io.Serializable;

/**
 * Created by JSADKFJ on 2016/11/22.
 */
public class ShoppingItme implements Serializable {

    // 商品id
    private String outId;

    // 商品名称
    private String name;

    // 商品单价
    private String price;

    // 商品数量
    private String num = "1";

    // 商品小计(数量*单价)
    private String prices;

    // 商品类型
    private String type;

    // 是否有货
    private String isHave = "true";


    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsHave() {
        return isHave;
    }

    public void setIsHave(String isHave) {
        this.isHave = isHave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingItme that = (ShoppingItme) o;

        if (outId != null ? !outId.equals(that.outId) : that.outId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        int result = outId != null ? outId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
