package dev.sainath.productService.thirdPartyClientProductServices.selfStore;

import dev.sainath.productService.dto.GenericProductDto;
import dev.sainath.productService.exceptions.NotFoundException;
import dev.sainath.productService.thirdPartyClientProductServices.ThirdPartyClient;

import java.util.List;

public class SelftStoreClient implements ThirdPartyClient<GenericProductDto> {
    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDto updateProdcutById(GenericProductDto toUpdate, Long id) throws NotFoundException {
        return null;
    }
}
