package com.example.StudentMenager.StudentMenager.service;

import com.example.StudentMenager.StudentMenager.dto.request.StudentRequsetDTO;
import com.example.StudentMenager.StudentMenager.dto.response.StudentResponseDTO;
import com.example.StudentMenager.StudentMenager.entity.Student;
import com.example.StudentMenager.StudentMenager.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //rregjistro nje student te ri ne dataabse
    //INPUT: Njeobjekt studentRequestDTO qe permban emrer, email, age
    //OUTPUT: nje objekt studentRespnseDTO qe i kthen klientit

    public StudentResponseDTO register(StudentRequsetDTO dto) {
        Student student = new Student(null, dto.getName(), dto.getEmail(), dto.getAge());
        Student saved = studentRepository.save(student);
        return new StudentResponseDTO(saved.getId(), saved.getName(), saved.getEmail(), saved.getAge());
    }
}
