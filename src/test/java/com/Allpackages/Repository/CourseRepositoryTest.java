package com.Allpackages.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Allpackages.Entity.Course;
import com.Allpackages.Entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	@Autowired
	CourseRepository cr;
	
	@Test
	public void testFindAllOfCourse() {
		
		List<Course> l= cr.findAll();
		System.out.println(l);
	}
	
	@Test
	public void saveCourseTeacher() {
		Teacher teacher=Teacher.builder()
				.Name("vasu")
				.build();
		Course course=Course.builder()
				.credit(20)
				.title("springBoot")
				.teacher(teacher).build();
		
		cr.save(course);
	}

}
