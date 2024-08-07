package com.bookstore.controller;

import com.bookstore.common.APIResponse;
import com.bookstore.dto.BookBulkRequestDto;
import com.bookstore.dto.BookEditionRequestDto;
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
    @PostMapping("/addBooksEdition")
    public ResponseEntity<APIResponse> addBookEdition(@RequestBody BookEditionRequestDto bookEditionRequestDto){
        APIResponse apiResponse = new APIResponse();
        APIResponse apiResponse1 = bookService.addBookEditionData(bookEditionRequestDto);
        apiResponse.setStatus(apiResponse1.getStatus());
        apiResponse.setData(apiResponse1.getData());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

    }
}
