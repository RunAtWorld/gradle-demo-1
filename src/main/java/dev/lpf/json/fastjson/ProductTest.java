package dev.json.fastjson;


import com.huawei.cbc.order.json.SerializerFeature;

import com.alibaba.fastjson.JSONObject;

import dev.json.fastjson.entity.Product;

/**
 * 对fastjson中的JSON转换做一个测试
 */
public class ProductTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Product product = new Product();
        product.setProductName("产品");
        product.setDesc("这是一个产品");
        product.setPrice("22.3");

        System.out.println("---fastjson---");
        String jsonStr = JSONObject.toJSONString(product);
        System.out.println("转换为json:" + jsonStr);
        // jsonStr = jsonStr.toUpperCase();
        jsonStr = jsonStr.replace("desc","desc2");
        jsonStr = jsonStr.replace("name","name2");
        System.out.println(jsonStr);
        product = JSONObject.parseObject(jsonStr, Product.class);
        System.out.println("json 转为 java object: " + product.toString());

        System.out.println("---jackson---");
        String jsonStr2 = com.huawei.cbc.order.json.JSON.toJSONString(product, SerializerFeature.WriteMapNullValue);
        System.out.println("转换为json:" + jsonStr2);
        // jsonStr = jsonStr.toUpperCase();
        jsonStr2 = jsonStr2.replace("desc","desc2");
        jsonStr2 = jsonStr2.replace("name","name2");
        System.out.println(jsonStr2);
        product = com.huawei.cbc.order.json.JSONObject.parseObject(jsonStr2, Product.class);
        System.out.println("json转为 java object: " + product.toString());
    }
}