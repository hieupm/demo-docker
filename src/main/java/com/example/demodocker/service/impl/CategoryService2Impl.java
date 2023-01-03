package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Category;
import com.example.demodocker.repo.CategoryRepository;
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
public class CategoryService2Impl implements CrudCommonService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(Object object) {
        categoryRepository.save((Category) object);
    }

    @Override
    public List<Object> getAll() {
        return Collections.singletonList(categoryRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
