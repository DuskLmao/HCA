package com.hca.database.factory;

import com.github.javafaker.Faker;
import com.hca.model.User;
import com.hca.model.UserRole;
import com.hca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    private final UserRepository userRepository;
    private final Faker faker = new Faker();
    @Autowired
    public UserFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void seedData() {
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            String password = "123456";
            String token = User.generateBcryptHash(password);

            String email = faker.internet().emailAddress();
            int atIndex = email.indexOf('@');
            String username = email.substring(0, atIndex);

            User user = User.builder()
                    .name(faker.name().fullName())
                    .username(faker.name().username())
                    .password(token)
                    .email(username + "@gmail.com")
                    .userRole(UserRole.USER)
                    .build();
            userRepository.save(user);
        }
    }
}
