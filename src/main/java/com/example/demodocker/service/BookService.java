package com.example.demodocker.service;

import com.example.demodocker.entities.Book;

import java.util.List;

public interface BookService {
    void insert(Book book);

    List<Book> listAll();

}
