package com.test.kt.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.test.kt.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Book saveBook(Book book) {
        dynamoDBMapper.save(book);
        return book;
    }

    public Book getBookById(String bookId) {
        return dynamoDBMapper.load(Book.class, bookId);
    }

    public String deleteBookById(String bookId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Book.class, bookId));
        return "Book Id : "+ bookId +" Deleted!";
    }

    public String updateBook(String bookId, Book book) {
        dynamoDBMapper.save(book,
                new DynamoDBSaveExpression()
        .withExpectedEntry("bookId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(bookId)
                )));
        return bookId;
    }
}