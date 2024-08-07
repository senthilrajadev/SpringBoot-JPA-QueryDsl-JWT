package com.bookstore.service;

import com.bookstore.common.APIResponse;
import com.bookstore.dto.BookBulkRequestDto;
import com.bookstore.dto.BookQueryDslDto;
import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepo;
    @Autowired
    private BookRepository bookRepository;


    public APIResponse getAllBooks(Integer yop) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(200);
//        List<Book> bookList = bookRepo.getBooksByDslQuery(yop);
        List<BookQueryDslDto> bookQueryDslDtoList = bookRepo.getBookDtosByDslQuery(yop);
        apiResponse.setData(bookQueryDslDtoList);
        return apiResponse;
    }

    public APIResponse saveBulkDtoData(BookBulkRequestDto bulkRequestDto) {
        List<Book> bookList = new ArrayList<>();

//        bulkRequestDto.getBooks().forEach(each -> {
//            Book book = new Book();
//            book.setTitle(each.getTitle());
//            book.setAuthor(each.getAuthor());
//            book.setYop(each.getYop());
//            book.setBookType(each.getBookType());
//            bookList.add(book);
//        });
        for(int i=0;i<100000;i++){
            Book book = new Book();
            book.setTitle("Sethil"+i);
            book.setAuthor("Author"+i);
            book.setYop(i);
            book.setBookType("BookType"+i);
            bookList.add(book);
        }
        bookRepository.saveAll(bookList);
        return new APIResponse();

    }
}
