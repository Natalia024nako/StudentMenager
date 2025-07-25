package com.example.StudentMenager.StudentMenager.repositories;

import com.example.StudentMenager.StudentMenager.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
