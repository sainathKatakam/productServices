package dev.sainath.productService.inheritanceDemo.mappedsuperclass;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "ms_st")
@Data
public class Student extends User {
    private double psp;
    private double attendance;
}
