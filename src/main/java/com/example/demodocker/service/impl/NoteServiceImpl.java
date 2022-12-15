package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Note;
import com.example.demodocker.repo.NoteRepository;
import com.example.demodocker.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void insert(Note note) {
        noteRepository.save(note);
    }

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteByBookId(String id) {
        return noteRepository.getNoteByBookId(id);
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
