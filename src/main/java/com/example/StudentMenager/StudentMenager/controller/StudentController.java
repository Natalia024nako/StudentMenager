package com.example.StudentMenager.StudentMenager.controller;

import com.example.StudentMenager.StudentMenager.dto.request.StudentRequsetDTO;
import com.example.StudentMenager.StudentMenager.dto.response.StudentResponseDTO;
import com.example.StudentMenager.StudentMenager.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponseDTO registerStudent(@RequestBody @Valid StudentRequsetDTO dto){
        return studentService.register(dto);
    }
}
