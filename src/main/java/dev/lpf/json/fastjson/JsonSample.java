package dev.lpf.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
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

        //设置json输出格式
        System.out.println("--特定json格式--");
        User user2 = new User();
        user2.setId(11L);
        user2.setCreateTime(new Date());
        String jsonString2 = JSON.toJSONString(user2, SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.UseSingleQuotes);
        System.out.println(jsonString2);
    }

    public static void deserialize() {
        String jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\"}";
        User user = JSON.parseObject(jsonString, new TypeReference<User>(){});
        System.out.println(user.getName());
        System.out.println(user.getCreateTime());
    }


}
