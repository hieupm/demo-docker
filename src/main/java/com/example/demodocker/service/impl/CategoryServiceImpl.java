package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Category;
import com.example.demodocker.repo.CategoryRepository;
import com.example.demodocker.service.CategoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("category")
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void insert(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public String checkUnique(Long id, String name) {
        boolean isCreatingNew = (id == null || id == 0);
        Category categoryByName = categoryRepository.findByName(name);

        if (isCreatingNew) {
            if (categoryByName != null) return "Duplicate";
        } else {
            if (categoryByName != null && categoryByName.getId() != id) {
                return "Duplicate";
            }
        }
        return "OK";
    }
}
