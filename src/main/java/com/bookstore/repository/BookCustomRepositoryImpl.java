package com.bookstore.repository;

import com.bookstore.entity.Book;
import com.bookstore.entity.QBook;
import com.querydsl.core.Tuple;
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
        List<Tuple> tuples = query
                .select(qBook.id, qBook.yop)
                .from(qBook)
                .where(qBook.yop.eq(yop)).fetch();
        List<Book> bookList = new ArrayList<>();
        for (Tuple tuple : tuples) {
            Book book = new Book();
            book.setId(tuple.get(qBook.id));
            book.setYop(tuple.get(qBook.yop));
            bookList.add(book);
        }

        return bookList;
    }
}
