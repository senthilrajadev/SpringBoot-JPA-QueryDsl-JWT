package com.bookstore.repository;

import com.bookstore.dto.BookQueryDslDto;
import com.bookstore.entity.Book;
import com.bookstore.entity.QBook;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

public class BookCustomRepositoryImpl implements  BookCustomRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Book> getBooksByDslQuery(Integer yop) {
        JPAQuery<Book> query = new JPAQuery<>(em);
        QBook qBook = QBook.book;

        // menthod 1 :: tuples
       /* List<Tuple> tuples = query
                .from(qBook)
                .where(qBook.yop.eq(yop)).fetch();
        List<Book> bookList = new ArrayList<>();
        for (Tuple tuple : tuples) {
            Book book = new Book();
            book.setId(tuple.get(qBook.id));
            book.setYop(tuple.get(qBook.yop));
            bookList.add(book);
        } */

        //method 2 :: Projection
        QBean<Book> bookQBean = Projections.bean(Book.class,qBook.id,qBook.yop);
        List<Book> books = query
                .select(bookQBean)
                .from(qBook)
                .where(qBook.yop.eq(yop)).fetch();

        return books;
    }

    @Override
    public List<BookQueryDslDto> getBookDtosByDslQuery(Integer yop) {
        QBook qBook = QBook.book;
        JPAQuery<BookQueryDslDto> jpaQuery = new JPAQuery<>(em);

        QBean<BookQueryDslDto> bookQueryDslDtoQBean = Projections.bean(BookQueryDslDto.class,qBook.id,qBook.title,qBook.bookType.as("type"));

        return jpaQuery
                .select(bookQueryDslDtoQBean)
                .from(qBook)
                .where(qBook.yop.eq(yop)).fetch();
    }
}
