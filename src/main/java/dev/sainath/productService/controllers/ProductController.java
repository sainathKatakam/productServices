package dev.sainath.productService.controllers;

import dev.sainath.productService.dto.ProductDto;
import dev.sainath.productService.thirdPartyClientProductServices.fakeStore.FakeStoreProductDto;
import dev.sainath.productService.dto.GenericProductDto;
import dev.sainath.productService.exceptions.NotFoundException;
import dev.sainath.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable String id) throws NotFoundException {
        return (GenericProductDto) productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
            return (ProductDto) this.productService.createProduct(genericProductDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable String id) throws NotFoundException {

        return new ResponseEntity(this.productService.deleteProductById(id), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ProductDto updateProductById(@RequestBody GenericProductDto genericProductDto,@PathVariable String id) throws NotFoundException {

        System.out.println("id:"+id);
        System.out.println(genericProductDto.toString());
        return (ProductDto) this.productService.updateProdcutById(genericProductDto,id);

    }

}
