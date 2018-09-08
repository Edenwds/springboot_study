package com.example.dynamic_datasource_method;

import com.example.dynamic_datasource_method.db.dao.UserMapper;
import com.example.dynamic_datasource_method.db.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDatasourceMethodApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect(){
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user.getId() + "--" + user.getName() + "==" + user.getGender());
	}

	@Test
	public void testInsert(){
		User user = new User();
		user.setId(3);
		user.setName("wjh");
		user.setGender("male");
		userMapper.insert(user);
		System.out.println("insert succeeded");
	}
}
