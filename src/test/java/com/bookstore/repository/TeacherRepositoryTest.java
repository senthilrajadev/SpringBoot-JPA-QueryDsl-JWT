package com.bookstore.repository;

import com.bookstore.entity.Course;
import com.bookstore.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherData(){
//        Course course = Course.builder()
//                .title("Spring")
//                .credit(4)
//                .build();
//        Course course1 = Course.builder()
//                .title("PHP")
//                .credit(5)
//                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mani")
                .lastName("Mekalai")
//                .courses(List.of(course,course1))
                .build();
        teacherRepository.save(teacher);
    }

}