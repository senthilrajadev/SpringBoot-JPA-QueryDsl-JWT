package com.bookstore.repository;

import com.bookstore.entity.Book;
import com.bookstore.entity.QBook;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class BookCustomRepositoryImpl implements  BookCustomRepository{

@PersistenceContext
EntityManager em;
    @Override
    public List<Book> getBooksByDslQuery(Integer yop) {
        JPAQuery<Book> query = new JPAQuery<>(em);
        QBook qBook = QBook.book;

        return query.from(qBook).where(qBook.yop.eq(yop)).fetch();
    }
}
