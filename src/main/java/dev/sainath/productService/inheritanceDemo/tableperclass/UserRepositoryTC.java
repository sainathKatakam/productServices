package dev.sainath.productService.inheritanceDemo.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryTC extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();
}
