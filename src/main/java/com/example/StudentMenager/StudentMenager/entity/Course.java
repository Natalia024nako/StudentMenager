package com.example.StudentMenager.StudentMenager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titulli nuk mund te jete bosh")
    private String title;

    @NotBlank(message = "pershkrimi nuk mund te jete bosh")
    private String description;

    @Min(value = 1, message = "Duhet te kete te paketn nje kredit")
    private int credits;

}
