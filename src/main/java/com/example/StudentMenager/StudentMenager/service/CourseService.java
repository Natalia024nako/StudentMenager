package com.example.StudentMenager.StudentMenager.service;

import com.example.StudentMenager.StudentMenager.dto.request.CourseRequestDTO;
import com.example.StudentMenager.StudentMenager.dto.response.CourseResponseDTO;
import com.example.StudentMenager.StudentMenager.entity.Course;
import com.example.StudentMenager.StudentMenager.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    //Siguron qe i gjithe aplikacioni ekzekutohet brenda nje transakcioni te vetem , nese ndosh ndonje gabim
    //psh tek save ath automatikisht anullohet i gjithe veeprimi pra behet rollBack ne dataBase dhe
    //perdoret per te garatuar integritetin e te dhenave

    @Transactional
    public CourseResponseDTO create(CourseRequestDTO dto){
        Course course = new Course(null, dto.getTitle(), dto.getDescription(), dto.getCerdits());
        Course saved = courseRepository.save(course);
        return new CourseResponseDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.getCredits());
    }
}
