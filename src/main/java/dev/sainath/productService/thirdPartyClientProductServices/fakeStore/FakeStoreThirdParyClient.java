package dev.sainath.productService.thirdPartyClientProductServices.fakeStore;

import dev.sainath.productService.configurations.ConfigProperties;
import dev.sainath.productService.dto.GenericProductDto;
import dev.sainath.productService.exceptions.NotFoundException;
import dev.sainath.productService.thirdPartyClientProductServices.ThirdPartyClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Data
public class FakeStoreThirdParyClient implements ThirdPartyClient<FakeStoreProductDto> {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder ;


    public String specificProdutUrl;
    public String allProductsUrl;

     FakeStoreThirdParyClient(RestTemplateBuilder restTemplateBuilder,
                              @Value("${fakestore.api.url}") String uri,
    @Value("${fakestore.api.paths.product}") String paths)
                                     {
        // TODO Auto-generated constructor stub
        this.restTemplateBuilder = restTemplateBuilder;
                                         System.out.println(uri+"-"+paths);
                                         this.specificProdutUrl = uri+paths+"/{id}";
                                         this.allProductsUrl = uri+paths;
                                         System.out.println(this.specificProdutUrl);
                                         System.out.println(this.allProductsUrl);

    }


    @Override
    public List<FakeStoreProductDto> getAllProducts() {
        // TODO Auto-generated method stub

        List<GenericProductDto> products = new ArrayList<GenericProductDto>() ;

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(allProductsUrl,FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeProducts =  response.getBody();

        List<FakeStoreProductDto> fp = Arrays.stream(response.getBody()).toList();

        return fp;


    }

    @Override
    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        // TODO Auto-generated method stub
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProdutUrl,FakeStoreProductDto.class,id);
        if(response.getBody() == null){
            throw new NotFoundException("The Product with ID: "+id+" doesn't exist");
        }

        return response.getBody();

    }

    @Override
    public FakeStoreProductDto deleteProductById(Long id) throws NotFoundException {
        // TODO Auto-generated method stub
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =	restTemplate.execute(specificProdutUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        if(response.getBody() == null)
            throw  new NotFoundException("The Product With ID: "+id+" Not-exist/deleted-already");
        return  response.getBody();
    }

    @Override
    public FakeStoreProductDto updateProdcutById(GenericProductDto toUpdate,Long id) throws NotFoundException {
        FakeStoreProductDto dbProduct = getProductById(id);
        doupdateProduct(dbProduct,toUpdate);
        ;
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback reqcallback	= restTemplate.httpEntityCallback(dbProduct);
        Map<String,Long> uriVariables = new HashMap<>();
        uriVariables.put("id",id);
        RequestCallback requestCallback = restTemplate.httpEntityCallback(dbProduct);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProdutUrl, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);

        return response.getBody();

    }

    private void doupdateProduct(FakeStoreProductDto dbProduct, GenericProductDto toUpdate) {

        if(dbProduct.getCategory() != toUpdate.getCategoryDto().getName()){
            dbProduct.setCategory(toUpdate.getCategoryDto().getName());
        }
        if(dbProduct.getDescription() != toUpdate.getDescritpion()){
            dbProduct.setDescription(toUpdate.getDescritpion());
        }
        if(dbProduct.getPrice() != toUpdate.getPriceDto().getPrice()){
            dbProduct.setPrice(toUpdate.getPriceDto().getPrice());
        }
        if(dbProduct.getImage() != toUpdate.getImage()){
            dbProduct.setImage(toUpdate.getImage());
        }
        if(dbProduct.getTitle() != toUpdate.getTitle()){
            dbProduct.setTitle(toUpdate.getTitle());
        }
    }

    @Override
    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        // TODO Auto-generated method stub

        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto response = restTemplate.postForObject(allProductsUrl, genericProductDto,FakeStoreProductDto.class);



        return response;

    }
}
