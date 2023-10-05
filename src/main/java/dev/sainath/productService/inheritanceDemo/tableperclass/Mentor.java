package dev.sainath.productService.inheritanceDemo.tableperclass;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "tc_mt")
@Data
public class Mentor extends User {
    private double averageRating;
}
