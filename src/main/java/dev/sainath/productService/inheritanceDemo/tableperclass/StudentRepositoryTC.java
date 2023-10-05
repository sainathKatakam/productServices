package dev.sainath.productService.inheritanceDemo.tableperclass;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryTC extends JpaRepository<Student,Long> {

    @Override
    <S extends Student> S save(S entity);
}
