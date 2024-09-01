package com.Allpackages.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Allpackages.Entity.Guardian;
import com.Allpackages.Entity.Student;


@SpringBootTest

class studentRepositoryTest {

	@Autowired
	private studentRepository sr;
		
	@Test
	public void saveStudentWithGuardian() {
		Guardian g=Guardian.builder()
				.name("guru1")
				.email("guru1@gamil.com")
				.mobile("1234567890")
				.build();
		
		Student st1=Student.builder()
				.firstName("shan")
				.lastName("king")
				.emailId("shan@gamil.com")
				.guardian(g)
				.build();
		
		
		sr.save(st1);
		
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList=sr.findAll();
		System.out.println("students list in table:-"+studentList);
	}
	
	
	@Test 
	public void printStudentsByFirstName() {
		List<Student> st=sr.findByFirstName("siva reddy venkata");
		System.out.println("students with firstname="+st);
	}
	
	@Test 
	public void printStudentsByFirstNameConatining() {

		List<Student> st=sr.findByFirstNameContaining("s");
		System.out.println("students with firstname containing s ="+st);
	}
	
	@Test
	public void printStudentsByGuardianName() {
		List<Student> s1=sr.findByGuardianName("guru1");
		System.out.println("students with Guardian Name="+s1);
	}
	@Test
	public void printStudentsByLastNameNotNull() {
		List<Student> s1=sr.findByLastNameNotNull();
		System.out.println("students with Last Name NotNull="+s1);
	}
	
	@Test
	public void printStudentsByFirstNameAndGuardianName() {
		Student s1=sr.findByFirstNameAndGuardianName("shan", "guru1");
		System.out.println("students with FirstName And GuardianName="+s1);
	}
	
//	query methods 
	
	@Test
	public void printStudentWithEmailId() {
		Student s=sr.findByEmailId("shan@gamil.com");
		System.out.println("print Student With EmailId"+s);
	}
	
	@Test
	public void printStudentFirstNameBasedOnEmailId() {
		String s=sr.findByFirstNameBasedOnEmailId("shan@gamil.com");
		System.out.println("**********print Student FirstName BasedOn EmailId="+s);
	}
	
//	Native query methods
	@Test
	public void printStudentWithEmailIdUsingNative() {
		Student s=sr.findByEmailIdUsingNative("venaktasivareddy@gamil.com");
		System.out.println("print Student With EmailId UsingNative="+s);
	}
	
	
// Native named parms query methods
	@Test
	public void printStudentWithEmailIdUsingNativeNamedParms() {
		Student s=sr.findByEmailIdUsingNativeNamedParma("venaktasivareddy@gamil.com");
		System.out.println("print Student With EmailId Using Native Named Parms="+s);
	}
	
//
	@Test
	public void updateTheGuardianNameBasedOnEmailId() {
		sr.updateGuardianNameBasedOnEmailId("guru2","venaktasivareddy@gamil.com");
		System.out.println("***********************************database updated*******************************************");
		
	}

}
