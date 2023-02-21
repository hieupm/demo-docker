package com.example.demodocker.controller;

import com.example.demodocker.config.Tracing;
import com.example.demodocker.entities.Category;
import com.example.demodocker.service.CategoryService;
import io.opentracing.Span;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping(value = "/category")
@Slf4j
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @Value("${spring.message}")
    private String message;

    @GetMapping("/env")
    public String envInfo(){
        return message;
    }

    @PreAuthorize("hasRole('test1')")
//    @Secured("ROLE_developer")
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        Span span = Tracing.tracer.buildSpan("my-operation").start();
        try{
            return ResponseEntity.ok(categoryService.listAll());
        } catch (Exception e){
            log.info("Error while querying category list: " + e);
            return null;
        } finally {
            span.finish();
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

}
