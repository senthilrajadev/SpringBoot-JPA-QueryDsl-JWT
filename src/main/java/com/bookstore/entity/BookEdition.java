package com.bookstore.entity;

import jakarta.persistence.*;

@Entity
public class BookEdition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer price;
    private Integer pageSize;
    private String description;
    private String isbn;
    @ManyToOne
    @JoinColumn(name="book_id" , referencedColumnName = "id")
    private Book book;

    public BookEdition() {
    }

    public BookEdition(Long id, Integer price, Integer pageSize, String description, String isbn) {
        this.id = id;
        this.price = price;
        this.pageSize = pageSize;
        this.description = description;
        this.isbn = isbn;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
