package com.library.Libraryapp.Repository;

import com.library.Libraryapp.domain.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {
}
