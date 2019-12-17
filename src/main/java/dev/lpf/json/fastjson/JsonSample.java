package dev.lpf.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import dev.lpf.json.fastjson.entity.User;
import dev.lpf.json.fastjson.entity.UserGroup;

import java.util.Date;
import java.util.List;

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
        System.out.println("-------对用户/用户组序列化------------");
        usertest();
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

    public static void usertest() {
        // 构建用户geust
        User guestUser = new User(){
            {
                this.setId(131L);
                this.setAge(18);
                this.setName("guest");
            }
        };
        // 构建用户root
        User rootUser = new User(){
            {
                this.setId(134L);
                this.setAge(28);
                this.setName("root");
            }
        };
        // 构建用户组对象
        System.out.println("--构建用户组 List--");
        UserGroup group = new UserGroup();
        group.setName("admin");
        group.getUserList().add(guestUser);
        group.getUserList().add(rootUser);

        // 用户组对象转JSON串
        String jsonString = JSON.toJSONString(group);
        System.out.println("jsonString:" + jsonString);

        // JSON串转用户组对象
        System.out.println("--JSON串转用户组对象--");
        UserGroup group2 = JSON.parseObject(jsonString, UserGroup.class);
        System.out.println("group2:" + group2);

        // 构建用户对象数组
        System.out.println("--用户对象数组 array--");
        User[] users = new User[2];
        users[0] = guestUser;
        users[1] = rootUser;
        // 用户对象数组转JSON串
        String jsonString2 = JSON.toJSONString(users);
        System.out.println("jsonString2:" + jsonString2);
        // JSON串转用户对象列表
        List<User> userList = JSON.parseArray(jsonString2, User.class);
        System.out.println("userList:" + userList);
    }
}
