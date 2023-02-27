package com.example.demodocker.service;

import com.example.demodocker.entities.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    List<Product> getAll();

    void delete(Long id);
}
