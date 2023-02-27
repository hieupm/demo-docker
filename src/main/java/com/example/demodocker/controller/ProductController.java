package com.example.demodocker.controller;

import com.example.demodocker.entities.Product;
import com.example.demodocker.service.CrudCommonService;
import com.example.demodocker.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        try{
            productService.getAll();
            return ResponseEntity.ok(productService.getAll());
        } catch (Exception e){
            log.info("Error while querying product list: " + e);
            return null;
        }

    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insert(@RequestBody Product product) {
        try{
            productService.save(product);
            log.info("Insert successfully with ID: " + product.getId());
            return ResponseEntity.ok(product.getId());
        } catch (Exception e){
            log.info("Error while inserting: " + e);
            return null;
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        try{
            productService.delete(id);
            return ResponseEntity.ok("Deleted successfully!");
        } catch (Exception e){
            log.info("Error while deleting: " + e);
            return null;
        }
    }

}
