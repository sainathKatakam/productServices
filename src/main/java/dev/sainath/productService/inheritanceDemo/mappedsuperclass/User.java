package dev.sainath.productService.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
