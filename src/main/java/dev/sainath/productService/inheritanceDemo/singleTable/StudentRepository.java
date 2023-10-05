package dev.sainath.productService.inheritanceDemo.singleTable;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Override
    <S extends Student> S save(S entity);
}
