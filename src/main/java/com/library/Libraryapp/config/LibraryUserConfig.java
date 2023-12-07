package com.library.Libraryapp.config;

import com.library.Libraryapp.Repository.LibraryUserRepository;
import com.library.Libraryapp.domain.LibraryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryUserConfig {

    private final LibraryUserRepository libraryUserRepository;

    @Autowired
    public LibraryUserConfig(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }
    @Bean
    public void loadLibraryUsers() {
     LibraryUser user1 = new LibraryUser();
     user1.setUsername("Mohammad");
     user1.setPassword("Mohammad2001");
     user1.setEmail("Mohammad@gmail.com");
     user1.setFullName("Mohammad Hamed");
     libraryUserRepository.save(user1);

     LibraryUser user2 = new LibraryUser();
        user2.setUsername("Omar");
        user2.setPassword("Omar1999");
        user2.setEmail("Omar@gmail.com");
        user2.setFullName("Omar Mohsen");
        libraryUserRepository.save(user2);

    LibraryUser user3 = new LibraryUser();
        user3.setUsername("Mariam");
        user3.setPassword("Mariam1998");
        user3.setEmail("Mariam@gmail.com");
        user3.setFullName("Mariam Ashraf");
        libraryUserRepository.save(user3);
}

}
