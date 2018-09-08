package com.example.dynamic_datasource_anno;

import com.example.dynamic_datasource_anno.db.pojo.User;
import com.example.dynamic_datasource_anno.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDatasourceAnnoApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSelect(){
		userService.select();
	}

	@Test
	public void testInsert(){
		User user = new User();
		user.setId(2);
		user.setName("wjy");
		user.setGender("female");
		userService.insert(user);
	}
}
