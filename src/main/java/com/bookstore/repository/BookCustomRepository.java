package com.bookstore.repository;

import com.bookstore.dto.BookQueryDslDto;
import com.bookstore.entity.Book;

import java.util.List;

public interface BookCustomRepository {
    List<Book> getBooksByDslQuery(Integer yop);

    List<BookQueryDslDto> getBookDtosByDslQuery(Integer yop);
}
