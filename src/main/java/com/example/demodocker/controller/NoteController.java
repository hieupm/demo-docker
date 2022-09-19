package com.example.demodocker.controller;

import com.example.demodocker.entities.Note;
import com.example.demodocker.repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/note")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        System.out.println("Note list: ");
        return ResponseEntity.ok(noteRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") long noteId) {
        return ResponseEntity.ok(noteRepository.getOne(noteId));
    }

    @PostMapping()
    public ResponseEntity<Long> persist(@RequestBody Note note) {
        noteRepository.save(note);

        return ResponseEntity.ok(999L);
    }

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(() -> {
            System.out.println("Hello World 1 " + Thread.currentThread().getName());
        }, 1000, TimeUnit.MILLISECONDS);
        executor.schedule(() -> {
            System.out.println("Hello World 2 " + Thread.currentThread().getName());
        }, 1000, TimeUnit.MILLISECONDS);
        executor.schedule(() -> {
            System.out.println("Hello World 3 " + Thread.currentThread().getName());
        }, 1000, TimeUnit.MILLISECONDS);
    }

}
