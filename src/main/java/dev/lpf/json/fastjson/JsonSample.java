package dev.lpf.json.fastjson;

import com.alibaba.fastjson.JSON;
import dev.lpf.json.fastjson.entity.User;

import java.util.Date;

/**
 * @program: gradle-demo-1
 * @description:
 * @author: Li Pengfei
 * @create: 2019-12-17 16:07
 **/
public class JsonSample {

    public static void main(String[] args) {
        System.out.println("--------序列化-----------");
        serialize();
        System.out.println("-------反序列化------------");
        deserialize();
    }

    public static void serialize() {
        User user = new User();
        user.setId(11L);
        user.setName("西安");
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
    }

    public static void deserialize() {
        String jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\"}";
        User user = JSON.parseObject(jsonString, User.class);
        System.out.println(user.getName());
        System.out.println(user.getCreateTime());
    }
}
