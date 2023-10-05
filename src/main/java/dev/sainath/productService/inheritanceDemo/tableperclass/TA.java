package dev.sainath.productService.inheritanceDemo.tableperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "tc_ta")
public class TA extends User {

        private double averageRating;

}
