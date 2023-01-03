package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Product;
import com.example.demodocker.repo.ProductRepository;
import com.example.demodocker.service.CrudCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@Qualifier("product")
@Primary
public class ProductService2Impl implements CrudCommonService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void save(Object object) {
        productRepository.save((Product) object);
    }

    @Override
    public List<Object> getAll() {
        return Collections.singletonList(productRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update() {
        System.out.println("Second");
    }
}
