package com.bookstore.repository;

import com.bookstore.entity.Course;
import com.bookstore.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void addCourseMaterial(){
        Course course = Course.builder()
                .title("Java")
                .credit(1)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }
    
    @Test
    public void fetchCourseMaterial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("courseMaterialList = " + courseMaterialList);
    }

}