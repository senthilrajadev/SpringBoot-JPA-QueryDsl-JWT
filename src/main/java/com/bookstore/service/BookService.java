package com.bookstore.service;

import com.bookstore.common.APIResponse;
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
        List<Book> bookList = bookRepo.getBooksByDslQuery(yop);
        apiResponse.setData(bookList);
        return apiResponse;
    }
}
