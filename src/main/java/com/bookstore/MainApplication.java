package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
           
            bookstoreService.fetchAuthorsIn();
        };
    }
}
/*
 * IN Clause Parameter Padding

Description: This application is an example of using Hibernate IN cluase parameter padding. This way we can reduce the number of Execution Plans. Mainly, Hibernate is padding parameters as follows:

for 3 and 4 parameters -> it uses 4 bind parameters (2^2)
for 5, 6, 7 and 8 parameters -> it uses 8 bind parameters (2^3)
for 9, 10, 11, 12, 13, 14, 15 and 16 parameters -> it uses 16 parameters (2^4)
...
Key points:

in application.properties set spring.jpa.properties.hibernate.query.in_clause_parameter_padding=true

 * 
 */
