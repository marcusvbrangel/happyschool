package com.marcusvbrangel.happyschool.repository;

import com.marcusvbrangel.happyschool.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

}
