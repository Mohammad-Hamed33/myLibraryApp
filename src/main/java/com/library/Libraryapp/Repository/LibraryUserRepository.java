package com.library.Libraryapp.Repository;

import com.library.Libraryapp.domain.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
    boolean existsByUsername(String username);
}
