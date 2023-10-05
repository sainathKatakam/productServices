package dev.sainath.productService.models;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseModel {

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category",cascade ={CascadeType.REMOVE},orphanRemoval = true)
    @Nullable
    private List<Product> products = new java.util.ArrayList<>();

}
