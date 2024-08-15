package com.bookstore.repository;

import com.bookstore.entity.Guardian;
import com.bookstore.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void studentTest(){
        Student sudent = Student.builder()
                .emailId("senthil@gmail.com")
                .firstName("Senthil")
                .lastName("Raja")
                //.guardianName("Mani")
                //.guardianEmail("Mani@gmail.com")
                //.guardianMobile("9999999999")
                .build();
        studentRepository.save(sudent);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Ravi")
                .email("ravi@gmail.com")
                .mobile("1234567890")
                .build();
        Student student = Student.builder()
                .firstName("Raja")
                .lastName("Senthil")
                .emailId("raja@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void studentList(){
        List<Student> student = studentRepository.findAll();
        System.out.println("student list = " + student);
    }

    @Test
    public void updateStudentFirstNameByEmail(){
        studentRepository.updateStudentNameByEmailId("Rajaaa","raja@gmail.com");

    }

}