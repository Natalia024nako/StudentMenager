package exceptions;

// eshte nje mekanizem per te trajtuar gabiment ne menyre te qarte i kap gabiment ne menyre automatike

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExecptionHandler {

    //Gabimet e validimit i trjaton
    // ne momentin qe ekzekutohet kur ndodh nje gabim validimi (@Email, @Min)
    //ath kthen mesazhin qe eshte paracaktuar me pare


    @ExceptionHandler
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException e){
        // khen nje objekt te tipit ResponseEntity ne formen e nje map
        //qe ka si celes nje string -> errors
        //dhe si vlere nje liste me stringje -> gabimet e validimit
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField()+ " : " + error.getDefaultMessage())
                .collect(Collectors.toList());

        Map<String, List<String>> response =  new HashMap<>();
        response.put("errors" , errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //Rasti kur nuk gjendet student
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleStudentNOtFound(StudentNotFoundException s){
        Map<String, List<String>> response =  new HashMap<>();
        response.put("error", Collections.singletonList(s.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //Rasti kur nuk gjendet kursi
    @ExceptionHandler(CourseNotFoundExeption.class)
    public ResponseEntity<Map<String, List<String>>> handleCourseNOtFound(CourseNotFoundExeption c){
        Map<String, List<String>> response =  new HashMap<>();
        response.put("error", Collections.singletonList(c.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
