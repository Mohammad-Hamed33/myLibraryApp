package com.library.Libraryapp.controller;

import com.library.Libraryapp.domain.BookOrder;
import com.library.Libraryapp.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-orders")
public class BookOrderController {

    private final BookOrderService bookOrderService;

    public BookOrderController(BookOrderService bookOrderService) {
        this.bookOrderService = bookOrderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookOrder>> getAllBookOrders() {
        List<BookOrder> bookOrders = bookOrderService.getAllBookOrders();
        return new ResponseEntity<>(bookOrders, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<BookOrder> getBookOrderById(@PathVariable("id") Long id) {
        BookOrder bookOrder = bookOrderService.getBookOrderById(id);
        return new ResponseEntity<>(bookOrder, HttpStatus.OK);
    }

    @PostMapping("/place-order")
    public ResponseEntity<BookOrder> placeBookOrder(@RequestBody BookOrder bookOrder) {
        System.out.println("Received request to place book order: " + bookOrder);
        BookOrder newBookOrder = bookOrderService.placeBookOrder(bookOrder);
        return new ResponseEntity<>(newBookOrder, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> cancelBookOrder(@PathVariable("id") Long id) {
        bookOrderService.cancelBookOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
