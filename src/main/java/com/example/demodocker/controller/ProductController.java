package com.example.demodocker.controller;

import com.example.demodocker.entities.Product;
import com.example.demodocker.service.CrudCommonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@Slf4j
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

    private final CrudCommonService crudCommonService;

    @GetMapping
    public ResponseEntity<List<Object>> getProducts() {
        try{
            crudCommonService.update();
            return ResponseEntity.ok(crudCommonService.getAll());
        } catch (Exception e){
            log.info("Error while querying product list: " + e);
            return null;
        }

    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insert(@RequestBody Product product) {
        try{
            crudCommonService.save(product);
            return ResponseEntity.ok(product.getId());
        } catch (Exception e){
            log.info("Error while inserting: " + e);
            return null;
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        try{
            crudCommonService.delete(id);
            return ResponseEntity.ok("Deleted successfully!");
        } catch (Exception e){
            log.info("Error while deleting: " + e);
            return null;
        }
    }

}
