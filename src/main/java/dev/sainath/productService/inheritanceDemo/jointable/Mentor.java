package dev.sainath.productService.inheritanceDemo.jointable;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "jt_mt")
@Data
public class Mentor extends User {
    private double averageRating;
}
