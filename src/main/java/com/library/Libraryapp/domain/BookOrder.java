package com.library.Libraryapp.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "book_order")
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "library_user_id")
    private LibraryUser libraryUser;

    @ManyToMany
    @JoinTable(
      name = "book_order_book",
      joinColumns = @JoinColumn(name = "book_order_id")
    )

   private List<Book> books;

    private LocalDateTime orderDate;
    private double totalAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
       this.id = id;
    }

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    public void setLibraryUser(LibraryUser libraryUser) {
        this.libraryUser = libraryUser;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }


    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }



}
