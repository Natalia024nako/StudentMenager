package com.example.StudentMenager.StudentMenager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {

    private Long id;
    private String title;
    private String description;
    private int credits;
}
