package com.hca.database.factory;

import com.github.javafaker.Faker;
import com.hca.model.Author;
import com.hca.model.Category;
import com.hca.repository.AuthorRepository;
import com.hca.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory {
    private final CategoryRepository categoryRepository;
    private final Faker faker = new Faker();
    @Autowired
    public CategoryFactory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void seedData() {
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setName(faker.name().fullName());
            categoryRepository.save(category);
        }
    }
}
