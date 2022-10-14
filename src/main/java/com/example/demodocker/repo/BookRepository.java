package com.example.demodocker.repo;

import com.example.demodocker.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM book")
    List<Book> getAllBooks();
}
