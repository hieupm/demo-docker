package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Book;
import com.example.demodocker.repo.BookRepository;
import com.example.demodocker.service.BookService;
import com.example.demodocker.service.CrudCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@Qualifier("book")
@Primary
public class BookService2Impl implements CrudCommonService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void save(Object object) {
        bookRepository.save((Book) object);
    }

    @Override
    public List<Object> getAll() {
        return Collections.singletonList(bookRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
