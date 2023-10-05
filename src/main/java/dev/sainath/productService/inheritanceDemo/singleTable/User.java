package dev.sainath.productService.inheritanceDemo.singleTable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity(name = "st_us")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type",discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
