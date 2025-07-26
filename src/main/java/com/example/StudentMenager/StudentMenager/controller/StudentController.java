package com.example.StudentMenager.StudentMenager.controller;

import com.example.StudentMenager.StudentMenager.dto.request.StudentRequsetDTO;
import com.example.StudentMenager.StudentMenager.dto.response.CourseResponseDTO;
import com.example.StudentMenager.StudentMenager.dto.response.StudentResponseDTO;
import com.example.StudentMenager.StudentMenager.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}/courses")
    public List<CourseResponseDTO> getCourses(@PathVariable Long id){
        return studentService.getCoursesForStudent(id);
    }

}
