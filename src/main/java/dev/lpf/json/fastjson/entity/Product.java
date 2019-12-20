package dev.json.fastjson.entity;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private String productName;
    private String desc;
    private String price;

    @JsonProperty("name")
    @JSONField(name="name")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("NAME2")
    @JSONField(name="NAME2")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("desc")
    @JSONField(name="desc")
    public String getDesc() {
        return desc;
    }

    @JsonProperty("DESC2")
    @JSONField(name="DESC2")  //测试代码中对jsonStr有一个toUpperCase的操作。就会这与"DESC"匹配
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @JSONField(name="price")
    public String getPrice() {
        return price;
    }

    @JSONField(name="PRICE2")
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
            "productName='" + productName + '\'' +
            ", desc='" + desc + '\'' +
            ", price='" + price + '\'' +
            '}';
    }
}