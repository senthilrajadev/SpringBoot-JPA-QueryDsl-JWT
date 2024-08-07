package com.bookstore.dto;

import java.util.List;

public class BookBulkRequestDto {

    private List<BookDto> books;

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
