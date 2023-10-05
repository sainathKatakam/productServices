package dev.sainath.productService.services;

import java.util.List;
import java.util.UUID;

import dev.sainath.productService.thirdPartyClientProductServices.fakeStore.FakeStoreProductDto;
import dev.sainath.productService.dto.GenericProductDto;
import dev.sainath.productService.exceptions.NotFoundException;


public interface ProductService<T1,T2> {

	public List<T1> getAllProducts();
	
	public T1 getProductById(String id) throws NotFoundException;

	
	public T2 createProduct(T1 genericProductDto);
	
	public T1 deleteProductById(String id) throws NotFoundException;

	public T2 updateProdcutById(T1 toUpdate,String id) throws NotFoundException;
	
	
}
