package com.example.demodocker.entities;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_ts")
    private Long createdTs;

    @Column(name = "updated_ts")
    private Long updatedTs;

    @Column(name = "note_content")
    @Type(type = "text")
    private String content;

    @Column(name = "note_title")
    @Type(type = "text")
    private String title;
//aha
}
