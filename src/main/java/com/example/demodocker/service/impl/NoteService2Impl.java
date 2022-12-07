package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Note;
import com.example.demodocker.repo.NoteRepository;
import com.example.demodocker.service.CrudCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@Qualifier("note")
public class NoteService2Impl implements CrudCommonService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void save(Object object) {
        noteRepository.save((Note) object);
    }

    @Override
    public List<Object> getAll() {
        return Collections.singletonList(noteRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
