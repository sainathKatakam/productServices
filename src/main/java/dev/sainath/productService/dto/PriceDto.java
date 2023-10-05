package dev.sainath.productService.dto;

import dev.sainath.productService.models.Price;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PriceDto {

    private String currency;
    private double price;

    public PriceDto(Price price){
        this.currency = price.getCurrency();
        this.price = price.getPrice();
    }

}
