package com.hca.database.factory;

import com.github.javafaker.Faker;
import com.hca.model.Author;
import com.hca.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorFactory {
    private final AuthorRepository authorRepository;
    private final Faker faker = new Faker();
    @Autowired
    public AuthorFactory(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void seedData() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setName(faker.name().fullName());
            authorRepository.save(author);
        }
    }
}
