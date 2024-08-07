package com.bookstore.dto;

import com.bookstore.entity.BookEdition;

import java.util.List;

public class BookEditionRequestDto {
    private String title;
    private String author;
    private String bookType;
    private Integer yop;
    private List<BookEditionDto> bookEditionDto;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Integer getYop() {
        return yop;
    }

    public void setYop(Integer yop) {
        this.yop = yop;
    }

    public List<BookEditionDto> getBookEditionDto() {
        return bookEditionDto;
    }

    public void setBookEditionDto(List<BookEditionDto> bookEditionDto) {
        this.bookEditionDto = bookEditionDto;
    }
}
