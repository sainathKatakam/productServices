package dev.sainath.productService.repositories;

import dev.sainath.productService.models.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    @Override
    Category save(Category category);

    @Override
    List<Category> findAll();


    Category findByNameEquals(String name);
}
