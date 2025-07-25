package com.example.StudentMenager.StudentMenager.controller;

import com.example.StudentMenager.StudentMenager.dto.request.CourseRequestDTO;
import com.example.StudentMenager.StudentMenager.dto.response.CourseResponseDTO;
import com.example.StudentMenager.StudentMenager.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponseDTO create (@RequestBody @Valid CourseRequestDTO dto){
        return courseService.create(dto);
    }
}
