package com.example.demodocker.controller;

import com.example.demodocker.entities.Note;
import com.example.demodocker.repo.NoteRepository;
import com.example.demodocker.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        System.out.println("Note list: ");
        return ResponseEntity.ok(noteService.listAll());
    }

    @GetMapping("/getOne")
    public ResponseEntity<Note> getNoteById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(noteService.getNoteByBookId(id));
    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insert(@RequestBody Note note) {
        noteService.insert(note);
        return ResponseEntity.ok(note.getId());
    }

    public static void main(String[] args) {

    }
}
