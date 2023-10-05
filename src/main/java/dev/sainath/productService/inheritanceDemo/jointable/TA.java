package dev.sainath.productService.inheritanceDemo.jointable;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "jt_ta")
public class TA extends User {

        private double averageRating;

}
