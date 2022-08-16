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

}
