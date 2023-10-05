package dev.sainath.productService.inheritanceDemo.jointable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryJT extends JpaRepository<Student,Long> {

    @Override
    <S extends Student> S save(S entity);
}
