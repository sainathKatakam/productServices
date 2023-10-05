package dev.sainath.productService.inheritanceDemo.singleTable;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "st_ta")
@DiscriminatorValue("4")
public class TA extends User {

        private double averageRating;

}
