package dev.sainath.productService.inheritanceDemo.jointable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MentorRepositoryJT extends JpaRepository<Mentor,Long> {

    @Override
    <S extends Mentor> S save(S entity);
}
