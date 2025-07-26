package com.example.StudentMenager.StudentMenager.service;

import com.example.StudentMenager.StudentMenager.dto.request.StudentRequsetDTO;
import com.example.StudentMenager.StudentMenager.dto.response.CourseResponseDTO;
import com.example.StudentMenager.StudentMenager.dto.response.StudentResponseDTO;
import com.example.StudentMenager.StudentMenager.entity.Course;
import com.example.StudentMenager.StudentMenager.entity.Enrollment;
import com.example.StudentMenager.StudentMenager.entity.Student;
import com.example.StudentMenager.StudentMenager.repositories.EnrollmentRepository;
import com.example.StudentMenager.StudentMenager.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    public StudentService(StudentRepository studentRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    //rregjistro nje student te ri ne dataabse
    //INPUT: Njeobjekt studentRequestDTO qe permban emrer, email, age
    //OUTPUT: nje objekt studentRespnseDTO qe i kthen klientit

    public StudentResponseDTO register(StudentRequsetDTO dto) {
        Student student = new Student(null, dto.getName(), dto.getEmail(), dto.getAge());
        Student saved = studentRepository.save(student);
        return new StudentResponseDTO(saved.getId(), saved.getName(), saved.getEmail(), saved.getAge());
    }

    public  List<CourseResponseDTO> getCoursesForStudent(Long studentId){
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);
        return enrollments.stream()
                //per cdo regjistrim e, merr kursin perkates me e.getCourse
                .map(enrollment -> {
                        Course c = enrollment.getCourse();
                return new CourseResponseDTO(
                        c.getId(),
                        c.getTitle(),
                        c.getDescription(),
                        c.getCredits()
                );


    }).toList();
}}
