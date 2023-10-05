package dev.sainath.productService.dto;

import dev.sainath.productService.models.Category;
import dev.sainath.productService.models.Product;
import lombok.*;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private String name;
    private List<Product> products;

    public CategoryDto(Category category){
        this.name = category.getName();
    }
}
