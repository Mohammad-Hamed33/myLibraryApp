package com.library.Libraryapp.controller;

import com.library.Libraryapp.domain.LibraryUser;
import com.library.Libraryapp.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library-users")
public class LibraryUserController {

    private final LibraryUserService libraryUserService;

    public LibraryUserController(LibraryUserService libraryUserService) {
     this.libraryUserService = libraryUserService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<LibraryUser>> getAllLibraryUsers() {
        List<LibraryUser> libraryUsers = libraryUserService.getAllLibraryUsers();
        return new ResponseEntity<>(libraryUsers, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<LibraryUser> getLibraryUserById(@PathVariable("id") Long id) {
        LibraryUser libraryUser = libraryUserService.getLibraryUserById(id);
        return new ResponseEntity<>(libraryUser, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<LibraryUser> registerLibraryUser(@RequestBody LibraryUser libraryUser) {
        System.out.println("Recieved request to register library user: " + libraryUser);
        LibraryUser newLibraryUser = libraryUserService.registerLibraryUser(libraryUser);
        return new ResponseEntity<>(newLibraryUser, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLibraryUser(@PathVariable("id") Long id) {
        libraryUserService.deleteLibraryUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

