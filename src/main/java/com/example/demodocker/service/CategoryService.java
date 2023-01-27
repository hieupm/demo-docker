package com.example.demodocker.service;

import com.example.demodocker.entities.Category;

import java.util.List;

public interface CategoryService {
    void insert(Category category);

    List<Category> listAll();
    
    void delete(Long id);

    String checkUnique(Long id, String name);
}
