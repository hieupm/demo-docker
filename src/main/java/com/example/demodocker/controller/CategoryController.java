package com.example.demodocker.controller;

import com.example.demodocker.entities.Category;
import com.example.demodocker.service.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasRole('test1')")
//    @Secured("ROLE_developer")
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        try{
            return ResponseEntity.ok(categoryService.listAll());
        } catch (Exception e){
            log.info("Error while querying category list: " + e);
            return null;
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insert(@RequestBody Category category) {
        try{
            categoryService.insert(category);
            return ResponseEntity.ok(category.getId());
        } catch (Exception e){
            log.info("Error while inserting: " + e);
            return null;
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id, @AuthenticationPrincipal Jwt jwt) {
        try{
            categoryService.delete(id);
            return ResponseEntity.ok("Deleted successfully with JWT object: " + jwt.getSubject());
        } catch (Exception e){
            log.info("Error while deleting: " + e);
            return null;
        }
    }
    //a
}
