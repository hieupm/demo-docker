package com.example.demodocker.service;

import com.example.demodocker.entities.Note;

import java.util.List;

public interface NoteService {
    void insert(Note note);

    List<Note> listAll();

    Note getNoteByBookId(String id);

}
