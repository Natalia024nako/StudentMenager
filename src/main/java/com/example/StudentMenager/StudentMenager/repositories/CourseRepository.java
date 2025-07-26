package com.example.StudentMenager.StudentMenager.repositories;

import com.example.StudentMenager.StudentMenager.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCreditsGreaterThan(int minCredits);
}

