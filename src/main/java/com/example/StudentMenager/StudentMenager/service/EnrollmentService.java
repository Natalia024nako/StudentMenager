package com.example.StudentMenager.StudentMenager.service;

import com.example.StudentMenager.StudentMenager.dto.request.EnrollmentRequestDTO;
import com.example.StudentMenager.StudentMenager.dto.response.StudentResponseDTO;
import com.example.StudentMenager.StudentMenager.entity.Course;
import com.example.StudentMenager.StudentMenager.entity.Enrollment;
import com.example.StudentMenager.StudentMenager.entity.Student;
import com.example.StudentMenager.StudentMenager.repositories.CourseRepository;
import com.example.StudentMenager.StudentMenager.repositories.EnrollmentRepository;
import com.example.StudentMenager.StudentMenager.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }
    //procesi i rregjistrimit

    @Transactional
    public void enroll(EnrollmentRequestDTO dto){
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(()->new RuntimeException("Studenti nuk ekziston"));
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(()-> new RuntimeException("Kursi nuk ekziston"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());

        //pasi e krijova objektin rregjistrim i bej save ne database
        enrollmentRepository.save(enrollment);
    }
    public List<StudentResponseDTO> getStudentsForCourse(Long courseId){
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(courseId);
        return enrollments.stream()
                .map(enrollment -> {
                    Student s = enrollment.getStudent();
                    return new StudentResponseDTO(
                            s.getId(),
                            s.getName(),
                            s.getEmail(),
                            s.getAge()
                    );
                }).toList();
    }

    public boolean isStudentEnrolled(Long studentId, Long courseId){
        return enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId);
    }

    @Transactional
    public void deleteEnrollment(Long id ){
        enrollmentRepository.deleteById(id);
    }

    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepository.findAll();
    }
}
