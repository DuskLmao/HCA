package com.hca.database.factory;

import com.github.javafaker.Faker;
import com.hca.model.Author;
import com.hca.model.Chapter;
import com.hca.repository.AuthorRepository;
import com.hca.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChapterFactory {
    private final ChapterRepository chapterRepository;
    private final Faker faker = new Faker();
    @Autowired
    public ChapterFactory(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public void seedData() {
        for (int i = 0; i < 10; i++) {
            Chapter chapter = new Chapter();
            chapter.setName(faker.name().fullName());
            chapterRepository.save(chapter);
        }
    }
}
