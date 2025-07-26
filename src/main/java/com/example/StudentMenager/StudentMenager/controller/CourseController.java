package com.example.StudentMenager.StudentMenager.controller;

import com.example.StudentMenager.StudentMenager.dto.request.CourseRequestDTO;
import com.example.StudentMenager.StudentMenager.dto.response.CourseResponseDTO;
import com.example.StudentMenager.StudentMenager.entity.Course;
import com.example.StudentMenager.StudentMenager.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/credits")
    public List<Course>getCourseWithMinCredits (@RequestParam int min){
        return courseService.getCourseWithMinCredits(min);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
}