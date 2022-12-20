package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Product;
import com.example.demodocker.repo.ProductRepository;
import com.example.demodocker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void insert(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

}
