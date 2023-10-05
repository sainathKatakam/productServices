package dev.sainath.productService.inheritanceDemo.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "st_mt")
@Data
@DiscriminatorValue("3")
public class Mentor extends User {
    private double averageRating;
}
