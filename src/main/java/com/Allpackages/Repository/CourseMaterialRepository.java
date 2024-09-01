package com.Allpackages.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Allpackages.Entity.Course;
import com.Allpackages.Entity.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
