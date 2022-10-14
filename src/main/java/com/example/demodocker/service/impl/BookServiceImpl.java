package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Book;
import com.example.demodocker.repo.BookRepository;
import com.example.demodocker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void insert(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> listAll() {
        List<Book> books = bookRepository.getAllBooks();
        Book book = books.get(0);
        book.getNotes();
        return bookRepository.findAll();
    }
}
