package com.Allpackages.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Allpackages.Entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
