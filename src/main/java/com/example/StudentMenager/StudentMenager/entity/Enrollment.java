package com.example.StudentMenager.StudentMenager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //nje student mund te regjistrohet ne disa kurse
    @ManyToOne(optional = false) //detyron qe fusha nuk mund te jete null
    private Student student;

    //nje kurs mund te kete disa student
    @ManyToOne(optional = false)
    private Course course;

    @NotNull (message = "Data e regjistrimit nuk mund te jete bosh")
    private LocalDate enrollmentDate;

    private Double grade;

}
