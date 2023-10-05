package dev.sainath.productService.dto;

import dev.sainath.productService.models.Category;
import dev.sainath.productService.models.Order;
import dev.sainath.productService.models.Price;
import dev.sainath.productService.models.Product;
import dev.sainath.productService.thirdPartyClientProductServices.fakeStore.FakeStoreProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericProductDto extends ProductDto{
	
	private String title;
	private String descritpion;
	private String image;
	private CategoryDto categoryDto;
	private PriceDto priceDto;
	private List<Order> orders;
	
	public GenericProductDto(FakeStoreProductDto fp){
		this.title = fp.getTitle();
		this.descritpion = fp.getDescription();
		this.image = fp.getImage();
		
	}
	public GenericProductDto(Product product){

		this.setTitle(product.getTitle());
		this.setImage(product.getImage());
		this.setDescritpion(product.getDescritpion());
		PriceDto priceDto = new PriceDto(product.getPrice());
		if(product.getCategory() != null){
			CategoryDto categoryDto = new CategoryDto(product.getCategory());

			this.setCategoryDto(categoryDto);
		}

		this.setPriceDto(priceDto);


	}
}
