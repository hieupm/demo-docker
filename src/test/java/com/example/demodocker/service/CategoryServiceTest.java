package com.example.demodocker.service;

import com.example.demodocker.entities.Category;
import com.example.demodocker.repo.CategoryRepository;

import com.example.demodocker.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

    @MockBean
    private CategoryRepository repo;

    @InjectMocks
    private CategoryService service = new CategoryServiceImpl(repo);

    @Test
    public void testCheckDuplicate(){
        Category category = new Category( 1L,"Test Category", null);

        Mockito.when(repo.save(category)).thenReturn(category);

        String result = service.checkUnique(category.getId(), category.getName());
        assertThat(result).isEqualTo("OK");
    }

}
