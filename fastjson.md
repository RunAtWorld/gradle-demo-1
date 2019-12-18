##### FastJSON 用法

###### FastJSON 一般用法

User.java

```
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private int age;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date   createTime;

}
```

UserGroup.java
```
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserGroup {
    private String name;
    List<User> userList = new ArrayList<>();
}
```

使用

```
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
```

###### JSONField与JSONType注解的使用

###### 参考
1. [fastjson Samples DataBind](https://github.com/alibaba/fastjson/wiki/Samples-DataBind)