package com.library.Libraryapp.service;

import com.library.Libraryapp.Repository.BookOrderRepository;
import com.library.Libraryapp.domain.Book;
import com.library.Libraryapp.domain.BookOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOrderService {

    private final BookOrderRepository bookOrderRepository;

    public BookOrderService(BookOrderRepository bookOrderRepository) {
        this.bookOrderRepository = bookOrderRepository;

    }

    public List<BookOrder> getAllBookOrders() {
        return bookOrderRepository.findAll();
    }

    public BookOrder getBookOrderById(Long id) {
        BookOrder bookOrder = bookOrderRepository.findById(id).orElse(null);
        return bookOrder;
    }
    public double calculateTotalAmount(List<Book> books) {
        double totalAmount = 0.0;

        for (Book book : books) {
            totalAmount += book.getPrice();
        }
        return totalAmount;
    }

    public BookOrder placeBookOrder(BookOrder bookOrder) {
     List<Book> books = bookOrder.getBooks();

     double totalAmount = calculateTotalAmount(books);
     bookOrder.setTotalAmount(totalAmount);

     return bookOrderRepository.save(bookOrder);
    }

    public void cancelBookOrder(Long id) {
        bookOrderRepository.deleteById(id);
    }
}
