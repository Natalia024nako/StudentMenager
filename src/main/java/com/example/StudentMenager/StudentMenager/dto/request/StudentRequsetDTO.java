package com.example.StudentMenager.StudentMenager.dto.request;

//kjo klase perdoret per te marr te dhena nga klienti (futet input) kur krijon
// ose perditeson nje student permes nje kerkerse HTTP (post ose put)
//kto i perdoriom pee te kontrolluar cfare te dhenash lejon alpikacioni te vine nga jashte
//per te vendosur validime si @NotBlank ose @Email dhe per te mos lejuar qe perdoresi te dergoje te dhena te padeshiruara si id

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequsetDTO {
    @NotBlank(message = "Emri nuk mund te jete bosh")
    private String name;

    @Email(message = "Email duhet te jete valid")
    @NotBlank(message = "Email nuk mund te lihet bosh")
    private String email;

    @Min(value = 16, message = "Mosha jo me e vogel se 16")
    private int age;


}
