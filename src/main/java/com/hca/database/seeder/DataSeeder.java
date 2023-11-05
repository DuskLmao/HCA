package com.hca.database.seeder;

import com.hca.database.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataSeeder {

    private final UserFactory userFactory;
    private final AuthorFactory authorFactory;
    private  final CategoryFactory categoryFactory;

    @Autowired
    public DataSeeder(UserFactory userFactory, AuthorFactory authorFactory, CategoryFactory categoryFactory) {

        this.userFactory = userFactory;
        this.authorFactory = authorFactory;
        this.categoryFactory = categoryFactory;
    }

//    @PostConstruct
//    public void seedData() {
//            userFactory.seedData();
//            authorFactory.seedData();
//            categoryFactory.seedData();
//        }
//    }

}