package com.test.kt.controller;


import com.test.kt.entity.Author;
import com.test.kt.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/add/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author) {
        return authorRepository.saveAuthor(author);
    }

    @GetMapping("/get/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable("id") String authorId) {
        return authorRepository.getAuthorById(authorId);
    }

    @DeleteMapping("/delete/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAuthorById(@PathVariable("id") String authorId) {
        return  authorRepository.deleteAuthorById(authorId);
    }

    @PutMapping("/update/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateAuthor(@PathVariable("id") String authorId, @RequestBody Author author) {
        return authorRepository.updateAuthor(authorId,author);
    }

}