package com.example.StudentMenager.StudentMenager.controller;

import com.example.StudentMenager.StudentMenager.dto.request.EnrollmentRequestDTO;
import com.example.StudentMenager.StudentMenager.dto.response.StudentResponseDTO;
import com.example.StudentMenager.StudentMenager.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<String> enrollStudent(@RequestBody EnrollmentRequestDTO dto){
        enrollmentService.enroll(dto);
        return ResponseEntity.ok("Studenti u rregjistrua ne rregull");
    }
    @GetMapping("/{id}/student")
    public List<StudentResponseDTO> getStudentForCourse(@PathVariable Long id){
        return enrollmentService.getStudentsForCourse(id);
    }

}
