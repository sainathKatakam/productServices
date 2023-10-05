package dev.sainath.productService.inheritanceDemo.singleTable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "st_st")
@Data
@DiscriminatorValue("2")
public class Student extends User {
    private double psp;
    private double attendance;
}
