package dev.sainath.productService.repositories;

import dev.sainath.productService.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public interface ProductRepository extends JpaRepository<Product, UUID> {


    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    Optional<Product> findById(UUID uuid);


}
