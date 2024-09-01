package com.Allpackages.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Allpackages.Entity.Course;
import com.Allpackages.Entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository tr;
	@Test
	public void saveTeacher() {
		
		Course course1=Course.builder()
				.credit(10)
				.title("java EE")
				.build();
		
		Teacher teacher=Teacher.builder()
				.Name("siva")
//				.courses(List.of(course1))
				.build();
		tr.save(teacher);
	}
}
