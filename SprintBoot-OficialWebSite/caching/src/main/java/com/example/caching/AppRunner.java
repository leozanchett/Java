package com.example.caching;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("...Fetching books");
        log.info("isbn-1234 -> {}", bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-4567 -> {}", bookRepository.getByIsbn("isbn-4567"));
        log.info("isbn-1234 -> {}", bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-4567 -> {}", bookRepository.getByIsbn("isbn-4567"));
        log.info("isbn-1234 -> {}", bookRepository.getByIsbn("isbn-1234"));
        log.info("isbn-1234 -> {}", bookRepository.getByIsbn("isbn-1234"));
    }
}
