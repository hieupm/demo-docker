package com.example.demodocker.controller;

import com.example.demodocker.entities.Note;
import com.example.demodocker.repo.NoteRepository;
import com.example.demodocker.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/note")
@Slf4j
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

    @PreAuthorize("hasRole('developer') or #id == #jwt.subject")
//    @Secured("ROLE_developer")
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String id, @AuthenticationPrincipal Jwt jwt) {
        try{
//            noteService.delete(id);
            return ResponseEntity.ok("Deleted successfully with JWT object: " + jwt.getSubject());
        } catch (Exception e){
            log.info("Error while deleting: " + e);
            return null;
        }
    }

}
