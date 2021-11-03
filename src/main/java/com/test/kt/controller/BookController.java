package com.test.kt.controller;


import com.test.kt.entity.Book;
import com.test.kt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/add/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.saveBook(book);
    }

    @GetMapping("/get/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable("id") String bookId) {
        return bookRepository.getBookById(bookId);
    }

    @DeleteMapping("/delete/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteBookById(@PathVariable("id") String bookId) {
        return  bookRepository.deleteBookById(bookId);
    }

    @PutMapping("/update/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateBook(@PathVariable("id") String bookId, @RequestBody Book book) {
        return bookRepository.updateBook(bookId,book);
    }

}