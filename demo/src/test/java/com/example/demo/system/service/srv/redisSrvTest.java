package com.example.demo.system.service.srv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisSrvTest {
    @Autowired
    RedisTemplate redisTemplate;





    @Test
    public void hh() {
        ValueOperations<String, String> valueStr = redisTemplate.opsForValue();
        //存储一条数据
        valueStr.set("test","长安");
        //获取一条数据并输出
        String goodsName = valueStr.get("test");
        System.out.println(goodsName);
//        //存储多条数据
//        Map<String,String> map = new HashMap<>();
//        map.put("goodsName","福特汽车");
//        map.put("goodsPrice","88888");
//        map.put("goodsId","88");
        redisTemplate.opsForZSet();
        redisTemplate.opsForSet().add("user:test","123");
        redisTemplate.opsForSet().add("user:test","123");
        redisTemplate.opsForSet().add("user:test","321");
        Set set =redisTemplate.opsForSet().members("user:test");
                System.out.println(set);
    }
    @Test
    public void test1(){
        User u = new User();
        u.setAge("18");
        u.setName("yys");
        redisTemplate.opsForValue().set("y:y:x",u.toString());
      //  System.out.println(redisTemplate.opsForValue().get("y:y:s"));
        System.out.println(redisTemplate.keys("y:y:*"));

       System.out.println(redisTemplate.boundValueOps("y:y:*"));

    }
}

class User {
    private String name ;
    private String age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}