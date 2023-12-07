package com.library.Libraryapp.config;

import com.library.Libraryapp.Repository.BookRepository;
import com.library.Libraryapp.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    private final BookRepository bookRepository;

    @Autowired
    public BookConfig(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Bean
    public Book book1() {
        Book book1 = new Book();
        book1.setTitle("The Inheritance Games");
        book1.setDescription("A suspenseful and thrilling novel.");
        book1.setPrice(19.99);
        book1.setCoverImageUrl("https://booktime584.files.wordpress.com/2023/03/inhertancegames.jpg");
        return bookRepository.save(book1);
    }

    @Bean
    public Book book2() {
        Book book2 = new Book();
        book2.setTitle("Darkest Minds");
        book2.setDescription("A dystopian science fiction novel.");
        book2.setPrice(14.99);
        book2.setCoverImageUrl("https://images.gr-assets.com/books/1343178841l/10576365.jpg");
        return bookRepository.save(book2);
    }

    @Bean
    public Book book3() {
        Book book3 = new Book();
        book3.setTitle("Divergent");
        book3.setDescription("A young adult science fiction novel.");
        book3.setPrice(12.99);
        book3.setCoverImageUrl("https://upload.wikimedia.org/wikipedia/en/f/f4/Divergent_%28book%29_by_Veronica_Roth_US_Hardcover_2011.jpg");
        return bookRepository.save(book3);
}
}