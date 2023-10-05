package dev.sainath.productService.inheritanceDemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ms_ta")
@Data
public class TA extends User {

        private double averageRating;

}
