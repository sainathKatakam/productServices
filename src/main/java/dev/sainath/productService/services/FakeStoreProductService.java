package dev.sainath.productService.services;

import dev.sainath.productService.adapters.FakeStoreProductAdapter;
import dev.sainath.productService.dto.ProductDto;
import dev.sainath.productService.thirdPartyClientProductServices.fakeStore.FakeStoreProductDto;
import dev.sainath.productService.dto.GenericProductDto;
import dev.sainath.productService.exceptions.NotFoundException;
import dev.sainath.productService.thirdPartyClientProductServices.fakeStore.FakeStoreThirdParyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductService implements ProductService<GenericProductDto, ProductDto>  {

	@Autowired
	private FakeStoreProductAdapter adapter;
	
	public FakeStoreProductService(FakeStoreProductAdapter adapter){
		this.adapter = adapter;
	}
	


	public List<GenericProductDto> getAllProducts() {

		return adapter.getAllProducts();
	}


	public GenericProductDto getProductById(String id) throws NotFoundException {
		return adapter.getProductById(id);

	}

	public GenericProductDto deleteProductById(String id) throws NotFoundException {
			return adapter.deleteProductById(id);
	}


	public FakeStoreProductDto updateProdcutById(GenericProductDto toUpdate,String id) throws NotFoundException {
		return adapter.updateProdcutById(toUpdate,id);
	}


	public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
		return adapter.createProduct(genericProductDto);
	}


}
