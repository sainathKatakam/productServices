package dev.sainath.productService.inheritanceDemo.tableperclass;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MentorRepositoryTC extends JpaRepository<Mentor,Long> {

    @Override
    <S extends Mentor> S save(S entity);
}
