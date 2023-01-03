package com.example.demodocker.service;

import com.example.demodocker.entities.Product;

import java.util.List;

public interface ProductService {
    void insert(Product product);

    List<Product> listAll();

}
