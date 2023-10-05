package dev.sainath.productService.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import dev.sainath.productService.dto.ProductDto;
import dev.sainath.productService.exceptions.NotFoundException;
import dev.sainath.productService.models.Category;
import dev.sainath.productService.models.Price;
import dev.sainath.productService.models.Product;
import dev.sainath.productService.repositories.CategoryRepository;
import dev.sainath.productService.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.sainath.productService.dto.GenericProductDto;

@Primary
@Service("selfStoreProductServiceImpl")
public class SelfStoreProductService implements ProductService<GenericProductDto, ProductDto>{
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	public SelfStoreProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<GenericProductDto> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
		List<GenericProductDto> genericProductDtos = new ArrayList<>();
		for(Product p : products){
			GenericProductDto gp = new GenericProductDto(p);
			genericProductDtos.add(gp);
		}
		return  genericProductDtos;

	}


	public GenericProductDto getProductById(String id) throws NotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(UUID.fromString(id));
		if(product.isEmpty()){
			throw new NotFoundException("The product with Id:"+id+" doesn't exist");
		}
		return new GenericProductDto(product.get());
	}


	public GenericProductDto deleteProductById(String id) throws NotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> op = productRepository.findById(UUID.fromString(id));
		if(op.isEmpty()){
			throw new NotFoundException("Invalid Id "+id);
		}
		productRepository.deleteById(UUID.fromString(id));
		return new GenericProductDto(op.get());
		
	}

	@Override
	public ProductDto updateProdcutById(GenericProductDto toUpdate, String id) throws NotFoundException {
		Optional<Product> optionalProduct = productRepository.findById(UUID.fromString(id));
		if(optionalProduct.isEmpty()){
			throw new NotFoundException("The Product with ID:"+id+" doesn't exist");
		}
		Product dbProduct = optionalProduct.get();

		if(dbProduct.getTitle() != toUpdate.getTitle() && toUpdate.getTitle() != null){
			dbProduct.setTitle(toUpdate.getTitle());
		}
		if(dbProduct.getPrice().getPrice() != toUpdate.getPriceDto().getPrice()){
			dbProduct.getPrice().setPrice(toUpdate.getPriceDto().getPrice());
		}
		if(dbProduct.getDescritpion() != toUpdate.getDescritpion() && toUpdate.getDescritpion() != null){
			dbProduct.setDescritpion(toUpdate.getDescritpion());
		}
		productRepository.save(dbProduct);
		return new GenericProductDto(dbProduct);
	}

	@Override
	public ProductDto createProduct(GenericProductDto gp) {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setImage(gp.getImage());
		p.setDescritpion(gp.getDescritpion());
		String categoryName = gp.getCategoryDto().getName();
		Category category = new Category();
		if(categoryName != null){
			 category = categoryRepository.findByNameEquals(categoryName);

		}
		if(category == null){
			category = new Category();
			category.setName(categoryName);
		}
		p.setCategory(category);
		p.setTitle(gp.getTitle());
		Price price = new Price();
		price.setPrice(gp.getPriceDto().getPrice());
		price.setCurrency(gp.getPriceDto().getCurrency());
		p.setPrice(price);
		Product dbProduct = productRepository.save(p);
		GenericProductDto genericProductDto = new GenericProductDto(dbProduct);
		return genericProductDto;
	}

}
