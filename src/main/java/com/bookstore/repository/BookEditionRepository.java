package com.bookstore.repository;

import com.bookstore.entity.BookEdition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEditionRepository extends JpaRepository<BookEdition, Long> {
}
