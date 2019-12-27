package dev.lpf.json.jackson.official;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lpf.json.jackson.official.entity.MyValue;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @program: gradle-demo-1
 * @description: jackson 官方 demo
 * @author: Li Pengfei
 * @create: 2019-12-27 11:35
 **/
public class JsonDemo {
    private static final Logger LOG = Logger.getLogger("JsonDemo");

    public static void main(String[] args) {
        try {
            pojos2json();
        } catch (IOException e) {
            LOG.severe("pojos2json 错误");
            e.printStackTrace();
        }
    }

    public static void pojos2json() throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

        MyValue myObject = new MyValue();
        myObject.age = 12;
        myObject.name = "zhang";
        mapper.writeValue(new File("result.json"), myObject);
        // or:
        byte[] jsonBytes = mapper.writeValueAsBytes(myObject);
        // or:
        String jsonString = mapper.writeValueAsString(myObject);

    }
}
