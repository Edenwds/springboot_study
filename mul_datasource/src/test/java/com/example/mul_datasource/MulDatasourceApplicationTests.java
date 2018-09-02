package com.example.mul_datasource;

import com.example.mul_datasource.db.dao.TeacherMapper;
import com.example.mul_datasource.db.pojo.Teacher;
import com.example.mul_datasource.db2.dao.StudentMapper;
import com.example.mul_datasource.db2.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MulDatasourceApplicationTests {

	@Autowired
	private TeacherMapper teacherMapper;

	@Autowired
	private StudentMapper studentMapper;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testSelectFirstDatasource(){
		Teacher teacher = teacherMapper.selectByPrimaryKey(1);
		System.out.println(teacher.getId() + "--" + teacher.getTname());
	}

	@Test
	public void testSelectSecondDatasource(){
		Student student = studentMapper.selectByPrimaryKey(1);
		System.out.println(student.getId() + "--" + student.getUname() + "--" + student.getAge());
	}
}
