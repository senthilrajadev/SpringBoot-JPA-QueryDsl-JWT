package com.bookstore.repository;

import com.bookstore.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query(
            value = "Update tbl_student set first_name= ?1 WHERE email_address = ?2 ",
               nativeQuery = true
    )
    int updateStudentNameByEmailId(String first_name, String email_address);

}
