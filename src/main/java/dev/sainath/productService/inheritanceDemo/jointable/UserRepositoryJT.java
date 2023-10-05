package dev.sainath.productService.inheritanceDemo.jointable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryJT extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();
}
