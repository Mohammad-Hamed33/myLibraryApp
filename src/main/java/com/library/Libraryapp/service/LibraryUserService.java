package com.library.Libraryapp.service;

import com.library.Libraryapp.Repository.LibraryUserRepository;
import com.library.Libraryapp.domain.LibraryUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryUserService {

    public final LibraryUserRepository libraryUserRepository;

    public LibraryUserService(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    public List<LibraryUser> getAllLibraryUsers() {
        return libraryUserRepository.findAll();
    }

    public LibraryUser getLibraryUserById(Long id) {
        LibraryUser libraryUser = libraryUserRepository.findById(id).orElse(null);
        return libraryUser;
    }
    public LibraryUser registerLibraryUser(LibraryUser libraryUser) {
        if (libraryUserRepository.existsByUsername(libraryUser.getUsername())) {
         return null;
        }
        return libraryUserRepository.save(libraryUser);
    }

    public void deleteLibraryUser(Long id) {
        libraryUserRepository.deleteById(id);
    }
}
