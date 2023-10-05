package dev.sainath.productService.thirdPartyClientProductServices.flipkartStore;

import dev.sainath.productService.dto.FlipkartProductDto;
import dev.sainath.productService.dto.GenericProductDto;
import dev.sainath.productService.exceptions.NotFoundException;
import dev.sainath.productService.thirdPartyClientProductServices.ThirdPartyClient;

import java.util.List;

public class FlipkartStoreClient implements ThirdPartyClient<FlipkartProductDto> {

    @Override
    public List<FlipkartProductDto> getAllProducts() {
        return null;
    }

    @Override
    public FlipkartProductDto getProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public FlipkartProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public FlipkartProductDto deleteProductById(Long id) throws NotFoundException {
        return null;
    }

    @Override
    public FlipkartProductDto updateProdcutById(GenericProductDto toUpdate, Long id) throws NotFoundException {
        return null;
    }
}
