package com.bookstore.controller;

import com.bookstore.common.APIResponse;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public APIResponse books(@RequestParam(name="yop") Integer yop) {
        return bookService.getAllBooks(yop);
    }
}
