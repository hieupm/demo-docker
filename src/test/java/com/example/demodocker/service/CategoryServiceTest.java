package com.example.demodocker.service;

import com.example.demodocker.entities.Category;
import com.example.demodocker.repo.CategoryRepository;
import com.example.demodocker.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    void testInsert(){
        Category category = new Category( "Test Category", null);
        categoryService.insert(category);
        Assertions.assertThat(category.getId()).isGreaterThan(0);
    }

}
