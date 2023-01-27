package com.example.demodocker.repo;

import com.example.demodocker.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoryRepoTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void testInsertCategory(){
        Category category = new Category( 1L,"Test Category", null);

        repository.save(category);

        assertThat(category.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAll() {
        Iterable<Category> categories = repository.findAll();
        categories.forEach(System.out::println);

        assertThat(categories).isNotEmpty();
    }

    @Test
    public void testGetById() {
        Category category = repository.findById(1L).get();

        assertThat(category.getName()).isEqualTo("Test Category");
    }

    @Test
    public void testUpdateName() {
        String newName = "Test 2";
        Category category = repository.findById(1L).get();
        category.setName(newName);

        Category savedBrand = repository.save(category);
        assertThat(savedBrand.getName()).isEqualTo(newName);
    }

    @Test
    public void testDelete() {
        Long id = 1L;
        repository.deleteById(id);

        Optional<Category> result = repository.findById(id);

        assertThat(result.isEmpty());
    }
}
