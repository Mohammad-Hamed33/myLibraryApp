package com.library.Libraryapp.controller;

import com.library.Libraryapp.domain.Book;
import com.library.Libraryapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        System.out.println("Received request to add book:" + book);
        Book newBook = bookService.saveBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.saveBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
