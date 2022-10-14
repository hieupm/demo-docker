package com.example.demodocker.controller;

import com.example.demodocker.entities.Book;
import com.example.demodocker.entities.Note;
import com.example.demodocker.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@Slf4j
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService noteService) {
        this.bookService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getNotes() {
        try{
            return ResponseEntity.ok(bookService.listAll());
        } catch (Exception e){
            log.info("Error while querying book list: " + e);
            return null;
        }

    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") long noteId) {
//        return ResponseEntity.ok(noteRepository.getOne(noteId));
//    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insert(@RequestBody Book book) {
        bookService.insert(book);
        return ResponseEntity.ok(book.getId());
    }
}
