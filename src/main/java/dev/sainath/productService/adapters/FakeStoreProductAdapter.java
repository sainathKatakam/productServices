package dev.sainath.productService.adapters;

import dev.sainath.productService.dto.CategoryDto;
import dev.sainath.productService.dto.GenericProductDto;
import dev.sainath.productService.dto.PriceDto;
import dev.sainath.productService.exceptions.NotFoundException;
import dev.sainath.productService.models.Price;
import dev.sainath.productService.services.ProductService;
import dev.sainath.productService.thirdPartyClientProductServices.fakeStore.FakeStoreProductDto;
import dev.sainath.productService.thirdPartyClientProductServices.fakeStore.FakeStoreThirdParyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FakeStoreProductAdapter implements ProductService<GenericProductDto,FakeStoreProductDto> {
    @Autowired
    private FakeStoreThirdParyClient client;
    public FakeStoreProductAdapter(FakeStoreThirdParyClient client){
        this.client = client;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProducts = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProducts =  client.getAllProducts();
        for(FakeStoreProductDto fp : fakeStoreProducts){
            genericProducts.add(new GenericProductDto(fp));
        }
        return genericProducts;
    }

    @Override
    public GenericProductDto getProductById(String id) throws NotFoundException {

        FakeStoreProductDto fakeProduct = client.getProductById(Long.valueOf(id));
        GenericProductDto genProduct = new GenericProductDto();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(fakeProduct.getCategory());
        genProduct.setCategoryDto(categoryDto);
        genProduct.setDescritpion(fakeProduct.getDescription());
        genProduct.setImage(fakeProduct.getImage());
        PriceDto priceDto = new PriceDto();
        priceDto.setPrice(fakeProduct.getPrice());
        genProduct.setPriceDto(priceDto);
        genProduct.setTitle(fakeProduct.getTitle());
        return genProduct;
    }

    @Override
    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        return client.createProduct(genericProductDto);
    }

    @Override
    public GenericProductDto deleteProductById(String id) throws NotFoundException {
        GenericProductDto gp = new GenericProductDto(client.deleteProductById(Long.valueOf(id)));
        return gp;

    }


    @Override
    public FakeStoreProductDto updateProdcutById(GenericProductDto toUpdate, String id) throws NotFoundException {
        return client.updateProdcutById(toUpdate,Long.valueOf(id));
    }
}
