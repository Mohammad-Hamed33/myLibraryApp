package com.library.Libraryapp.config;

import com.library.Libraryapp.Repository.BookOrderRepository;
import com.library.Libraryapp.domain.Book;
import com.library.Libraryapp.domain.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
public class BookOrderConfig {

    private final BookOrderRepository bookOrderRepository;
    private final Book book1;
    private final Book book2;

    @Autowired
    public BookOrderConfig(BookOrderRepository bookOrderRepository, Book book1, Book book2) {
        this.bookOrderRepository = bookOrderRepository;
        this.book1 = book1;
        this.book2 = book2;
    }

    @Bean
    public void loadBookOrders() {
        BookOrder bookOrder1 = new BookOrder();
        bookOrder1.setOrderDate(LocalDateTime.now());
        bookOrder1.setTotalAmount(34.98);
        bookOrder1.setBooks(Arrays.asList(book1, book2));

        bookOrderRepository.save(bookOrder1);

        // You can add more book orders as needed
        // ...

        BookOrder bookOrder2 = new BookOrder();
        bookOrder2.setOrderDate(LocalDateTime.now());
        bookOrder2.setTotalAmount(27.98);
        bookOrder2.setBooks(Arrays.asList(book2));

        bookOrderRepository.save(bookOrder2);
    }
}