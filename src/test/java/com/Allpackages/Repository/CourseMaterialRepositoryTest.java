package com.Allpackages.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Allpackages.Entity.Course;
import com.Allpackages.Entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {
	
	@Autowired
	CourseMaterialRepository cmr;
	
	@Test
	public void postData() {
		
		Course c=Course.builder()
				.credit(8)
				.title("Google")
				.build();
		
		CourseMaterial cm=CourseMaterial.builder()
				.url("www.google.com")
				.course(c)
				.build();
		
		cmr.save(cm);
		
	}
	
	@Test
	public void getAllCourseMaterial() {
		List<CourseMaterial> l=cmr.findAll();
		System.out.println(l);
	}
}
