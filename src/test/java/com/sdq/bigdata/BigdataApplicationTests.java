package com.sdq.bigdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BigdataApplicationTests {

    @Autowired
   public RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("name","sdq");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

}
