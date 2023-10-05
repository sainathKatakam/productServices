package dev.sainath.productService.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "ms_mt")
@Data
public class Mentor extends User{
    private double averageRating;
}
