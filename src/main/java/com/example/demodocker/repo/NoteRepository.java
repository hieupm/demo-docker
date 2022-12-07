package com.example.demodocker.repo;

import com.example.demodocker.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM NOTE WHERE book_id = ?1")
    Note getNoteByBookId(String id);
}
