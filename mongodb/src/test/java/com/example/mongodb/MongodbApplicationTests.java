package com.example.mongodb;

import com.example.mongodb.domain.User;
import com.example.mongodb.interfaces.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

//	@Before
//	public void setUp(){
//		userRepository.deleteAll();
//	}
	@Test
	public void contextLoads() {
	}

	@Test
	public void test() {
		userRepository.save(new User("1001","zhangsan",11));
		userRepository.save(new User("1002","lisi",12));
		userRepository.save(new User("1003","wangwu",13));

		System.out.println(userRepository.findAll().size());
		User user = userRepository.findUserByUname("zhangsan");
		System.out.println(user.getUid());
	}

	@Test
	public void testFindOne() {
		User user1 = userRepository.findOne("1001");
		System.out.println(user1.getUname() + ":" + user1.getAge());
	}

	@Test
	public void testFindByAge() {
		Integer age = 13;
		User user = userRepository.findUserByAge(age);
		System.out.println(user.getUname());
	}

	@Test
	public void testFindByUidAndAge() {
		String uid = "1002";
		Integer age = 12;
		User user = userRepository.findUserByUidAndAge(uid, age);
		if (user == null) {
			System.out.println("not found data");
		} else {
			System.out.println(user.getUname());
		}
	}

	@Test
	public void testFindByAges() {
		Integer[] ages = {11, 12};
		List<User> users = userRepository.findUsersByAgeIn(ages);
		users.forEach(user -> System.out.println(user.getUname()));
	}

	@Test
	public void testFindByUidsOrderByAge() {
		List<User> users = userRepository.findUsersByUidBetweenOrderByAgeDesc("1000", "1003");
		users.forEach(user -> System.out.println(user.getUname() + " " + user.getAge()));
	}

	@Test
	public void testFindByUnames() {
		String[] names = {"lisi", "wangwu"};
		List<User> users = userRepository.findUsersByUnameIn(names);
		users.forEach(user -> System.out.println(user.getUname()));
	}

	@Test
	public void testFindByUids() {
		List<User> users = userRepository.findUsersByUidContaining("1001");
		System.out.println(users.size());
		users.forEach(user -> System.out.println(user.getUname()));
	}

	@Test
	public void testPageFind() {
        String[] uids = {"1001", "1002","1003"};
        Pageable pageable = new PageRequest(0, 2, new Sort(Sort.Direction.DESC, "age"));
        Page<User> userPage = userRepository.findUsersByUidIn(pageable, uids);
        System.out.println(userPage.getTotalElements());
        userPage.forEach(user -> System.out.println(user.getUname() + " : " + user.getAge()));
    }

    @Test
    public void testTemplate() {
        Query query = new Query(new Criteria("uid").is("1001"));
	    List<User> users = mongoTemplate.find(query, User.class, "user");
	    users.forEach(user -> System.out.println(user.getUname()));
    }

}
