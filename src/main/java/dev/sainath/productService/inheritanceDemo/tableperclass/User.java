package dev.sainath.productService.inheritanceDemo.tableperclass;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
