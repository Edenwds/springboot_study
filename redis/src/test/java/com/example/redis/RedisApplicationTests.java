package com.example.redis;

import com.example.redis.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Resource(name = "redisTemplate")
	private RedisTemplate redisTemplate;

	@Resource(name = "userRedisTemplate")
	private RedisTemplate<String,User> userRedisTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRedisOpt(){
		redisTemplate.boundValueOps("one").set("hello redis",100, TimeUnit.SECONDS);
	}

	@Test
	public void testRedisZSetOpt(){
		for(int i = 0 ; i < 10; i++){
			redisTemplate.boundZSetOps("two").add("100" + i,new Random().nextInt(100));
		}
		redisTemplate.boundZSetOps("two").expire(3600,TimeUnit.SECONDS);
	}

	@Test
	public void testRedisZSetOpt2(){
		Set<String> ids = redisTemplate.boundZSetOps("two").reverseRange(0,-1);
		ids.forEach(System.out::println);
	}

	@Test
	public void testRedisUser(){
		User user = new User();
		user.setName("zhangsan");
		user.setAge(23);
		user.setGender("male");
		userRedisTemplate.opsForValue().set(user.getName(),user,3600,TimeUnit.SECONDS);
	}

	@Test
	public void testRedisUser2(){
		User user = userRedisTemplate.opsForValue().get("zhangsan");
		System.out.println(user.getAge() + ":" + user.getGender());
	}
}
