package dev.sainath.productService.thirdPartyClientProductServices.fakeStore;

import dev.sainath.productService.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FakeStoreProductDto extends ProductDto {

	private Long id;
	private String title;
	private double price;
	private String category;
	private String description;
	private String image;

}
