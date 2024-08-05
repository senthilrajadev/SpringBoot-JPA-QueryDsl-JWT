package com.bookstore.service;

import com.bookstore.common.APIResponse;
import com.bookstore.dto.BookQueryDslDto;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepo;


    public APIResponse getAllBooks(Integer yop) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(200);
//        List<Book> bookList = bookRepo.getBooksByDslQuery(yop);
        List<BookQueryDslDto> bookQueryDslDtoList = bookRepo.getBookDtosByDslQuery(yop);
        apiResponse.setData(bookQueryDslDtoList);
        return apiResponse;
    }
}
