package dev.sainath.productService.thirdPartyClientProductServices;

import dev.sainath.productService.dto.GenericProductDto;
import dev.sainath.productService.exceptions.NotFoundException;

import java.util.List;

public interface ThirdPartyClient<T> {

    public List<T> getAllProducts();

    public T getProductById(Long id) throws NotFoundException;

    public T createProduct(GenericProductDto genericProductDto);

    public T deleteProductById(Long id) throws NotFoundException;

    public T updateProdcutById(GenericProductDto toUpdate,Long id) throws NotFoundException;


}
