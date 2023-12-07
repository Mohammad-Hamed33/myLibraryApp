package com.library.Libraryapp.Repository;

import com.library.Libraryapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
