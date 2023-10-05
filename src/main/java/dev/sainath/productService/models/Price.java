package dev.sainath.productService.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Price extends BaseModel{
    private String currency;
    private double price;
    @OneToOne
    private Product product;
}
