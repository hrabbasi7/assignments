package com.test.kt.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.test.kt.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Author saveAuthor(Author author) {
        dynamoDBMapper.save(author);
        return author;
    }

    public Author getAuthorById(String authorId) {
        return dynamoDBMapper.load(Author.class, authorId);
    }

    public String deleteAuthorById(String authorId) {
        dynamoDBMapper.delete(dynamoDBMapper.load(Author.class, authorId));
        return "Author Id : "+ authorId +" Deleted!";
    }

    public String updateAuthor(String authorId, Author Author) {
        dynamoDBMapper.save(Author,
                new DynamoDBSaveExpression()
        .withExpectedEntry("authorId",
                new ExpectedAttributeValue(
                        new AttributeValue().withS(authorId)
                )));
        return authorId;
    }
}