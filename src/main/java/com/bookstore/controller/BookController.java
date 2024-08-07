package com.bookstore.controller;

import com.bookstore.common.APIResponse;
import com.bookstore.dto.BookBulkRequestDto;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public APIResponse books(@RequestParam(name="yop") Integer yop) {
        return bookService.getAllBooks(yop);
    }

    @PostMapping("/bulkbooks")
    public ResponseEntity<APIResponse> bulkBookInsert(@RequestBody BookBulkRequestDto bulkRequestDto) {
        APIResponse apiResponse = new APIResponse();
        bookService.saveBulkDtoData(bulkRequestDto);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData("Success");
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
}
