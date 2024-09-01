package com.Allpackages.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Allpackages.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
