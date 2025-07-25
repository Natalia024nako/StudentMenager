package com.example.StudentMenager.StudentMenager.repositories;

import com.example.StudentMenager.StudentMenager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
