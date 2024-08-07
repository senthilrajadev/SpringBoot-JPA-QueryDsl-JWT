package com.bookstore.entity;

import com.querydsl.core.annotations.QueryEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(generator = "abc") //mysql didnt support GenerationType.SEQUENCE .so used other method
    @GenericGenerator(name="abc", strategy = "increment")
    private Long id;
    private String title;
    private String author;
    @Column(name="year_of_publication")
    private Integer yop;
    private String bookType;

    public Book() {
    }

    public Book(Long id, String title, String author, Integer yop, String bookType) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yop = yop;
        this.bookType = bookType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getYop() {
        return yop;
    }

    public void setYop(Integer yop) {
        this.yop = yop;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
