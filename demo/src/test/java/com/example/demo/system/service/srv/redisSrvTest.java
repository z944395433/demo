package com.example.demo.system.service.srv;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

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


    }
}