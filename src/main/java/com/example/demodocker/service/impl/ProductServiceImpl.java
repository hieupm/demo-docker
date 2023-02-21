package com.example.demodocker.service.impl;

import com.example.demodocker.entities.Product;
import com.example.demodocker.repo.ProductRepository;
import com.example.demodocker.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
