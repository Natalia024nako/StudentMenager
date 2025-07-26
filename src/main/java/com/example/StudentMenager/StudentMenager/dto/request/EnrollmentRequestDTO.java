package com.example.StudentMenager.StudentMenager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequestDTO {
    private Long studentId;
    private Long courseId;

}
