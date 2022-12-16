package com.example.demodocker.controller;

import com.example.demodocker.entities.Book;
import com.example.demodocker.service.BookService;
import com.example.demodocker.service.CrudCommonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@Slf4j
@SecurityRequirement(name = "bearerAuth")
public class BookController {

    private CrudCommonService crudCommonService;

    @Autowired
    public BookController(CrudCommonService crudCommonService) {
        this.crudCommonService = crudCommonService;
    }

    @GetMapping
    public ResponseEntity<List<Object>> getNotes() {
        try{
            return ResponseEntity.ok(crudCommonService.getAll());
        } catch (Exception e){
            log.info("Error while querying book list: " + e);
            return null;
        }

    }

    @PostMapping("/insert")
    public ResponseEntity<Long> insert(@RequestBody Book book) {
        try{
            crudCommonService.save(book);
            return ResponseEntity.ok(book.getId());
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

//    @PutMapping("/update-author")
//    public ResponseEntity<String> insert(@RequestParam Long id) {
//        try{
//            crudCommonService.updateAuthor(id);
//            return ResponseEntity.ok("Update successfully");
//        } catch (Exception e){
//            log.info("Error while updating book: " + e);
//            return ResponseEntity.ok("Update failed");
//        }
//
//    }
}
