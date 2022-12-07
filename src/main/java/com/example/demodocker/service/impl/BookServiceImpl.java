package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Book;
import com.example.demodocker.repo.BookRepository;
import com.example.demodocker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void insert(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public void updateAuthor(Long id) {
        bookRepository.updateAuthor(id);
    }

    public static void main(String[] args) {
        Book book = Book.builder()
                .name("Test")
                .build();

        Book.BookBuilder bookBuilder = book.toBuilder();
        Book newBook = bookBuilder
                .name("Demo")
                .authorName("HieuPM")
                .build();
        System.out.println(newBook.toString());
    }

}
