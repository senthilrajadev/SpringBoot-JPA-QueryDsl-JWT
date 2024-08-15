package com.bookstore.repository;

import com.bookstore.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findAll() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseAndTeacherData(){
        Teacher teacher = Teacher.builder()
                .firstName("Senthil")
                .lastName("Raja")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(5)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCourseDetails(){

        Teacher teacher = Teacher.builder()
                .firstName("Ai Raja1")
                .lastName("Don1")
                .build();

        Guardian guardian = Guardian.builder()
                .name("Guard dog1")
                .email("guarddog1@gmail.com")
                .mobile("88347347732673621")
                .build();
        Student student = Student.builder()
                .firstName("Poosh1")
                .lastName("Kutty1")
                .emailId("kutty1@gmail.com")
                .guardian(guardian)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.senthil1.com")
                .build();

        Course course = Course.builder()
                .title("AII")
                .credit(9)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        course.addCourseMaterial(courseMaterial);
        courseRepository.save(course);
    }
}