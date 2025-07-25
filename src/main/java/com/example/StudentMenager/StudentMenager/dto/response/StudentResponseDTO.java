package com.example.StudentMenager.StudentMenager.dto.response;

//Perdoret per te kthyer te dhenat nga backend tek klienti
//output per nje get ose post
//perdoret per te kontrolluar cfare i dergojme klientit
//per te bere pergjigjen ne nje forme me te paster

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
    private int age;

}
