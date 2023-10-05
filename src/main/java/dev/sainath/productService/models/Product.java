package dev.sainath.productService.models;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String descritpion;
    private String image;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category")
    private Category category;

    @OneToOne(cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
    private Price price;
    @ManyToMany
    private List<Order> orders;

}
