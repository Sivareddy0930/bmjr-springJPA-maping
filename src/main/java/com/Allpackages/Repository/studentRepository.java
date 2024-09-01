package com.Allpackages.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Allpackages.Entity.Student;


@Repository
public interface studentRepository extends JpaRepository<Student,Long> {
//	custom methods 
	List<Student> findByFirstName(String fname);
	
	List<Student> findByFirstNameContaining(String fname);
	
	List<Student> findByGuardianName(String gname);
	
	List<Student> findByLastNameNotNull();
	
	Student findByFirstNameAndGuardianName(String fname,String gname);
//-------------------------------------------------------------------------------------------------------------	
//	custom query's	
//java persistence query language (JPQL) query's
// jpql query's can build  based on java classes and its properties. but not based on tables names and column names .
// while we writing the jpql query we just use the class name as table name and column names as properties names .
	
//by using @Query we can build jpql query.
	
	@Query("select s from Student s where s.emailId= ?1")
	Student findByEmailId(String email);
	
	@Query("select s.firstName from Student s where s.emailId= ?1")
	String findByFirstNameBasedOnEmailId(String email);
	
//	-------------------------------------------------------------------------------------------------
//	Native query 
//	if we want to write the query in sql format we use native query syntax. it is use when we cant decleared our requrement in jpql .we use native query.
//	In native query we use table name and column names to build query instead of class name and properties names.
//	simple example
	
	@Query(
			value="SELECT * FROM student_tbl WHERE email_address= ?1",
			nativeQuery = true
			)
	Student findByEmailIdUsingNative(String email);
//---------------------------------------------------------------------------------------------------	
//	Native Named Parma query 
//	instead of ?1   we can also use proper naming conventions.
	
	@Query(
			value="SELECT * FROM student_tbl WHERE email_address= :emailId",
			nativeQuery = true
			)
//	:email is a named parameter in the query.
	Student findByEmailIdUsingNativeNamedParma(@Param("emailId") String email);
//	-------------------------------------------------------------------------------------------------------------------------
	
	@Transactional
	//	By using @Transactional, you ensure that the annotated method is executed within a transactional context, 
	//	and Spring will manage the opening, committing, and rolling back of transactions as needed. 
	
	
	@Modifying
	//	Indicates a query method should be considered as modifying query as that changes the way it needs to be executed.
	//	This annotation is only considered if used on query methods defined through a Query annotation.
	//	It's notapplied on custom implementation methods or queries derived from the method name as they already have control overthe underlying data access APIs or specify if they are modifying by their name
	
	@Query(
			value="update student_tbl set guardian_name= ?1 where email_address= ?2",
			nativeQuery = true
			)

	int updateGuardianNameBasedOnEmailId(String gname,String EmailId);
	
	
}
