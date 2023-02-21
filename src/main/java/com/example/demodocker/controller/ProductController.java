package com.example.demodocker.controller;

import com.example.demodocker.entities.Product;
import com.example.demodocker.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@Slf4j
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        try{
            return ResponseEntity.ok(productService.listAll());
        } catch (Exception e){
            log.info("Error while querying product list: " + e);
            return null;
        }

    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insert(@RequestBody Product product) {
        try{
            productService.save(product);
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
