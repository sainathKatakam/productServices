package dev.sainath.productService.inheritanceDemo.tableperclass;


import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "tc_st")
@Data
public class Student extends User {
    private double psp;
    private double attendance;
}
