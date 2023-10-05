package dev.sainath.productService.inheritanceDemo.jointable;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "jt_st")
@Data
public class Student extends User {
    private double psp;
    private double attendance;
}
