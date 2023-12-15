package com.example.productservice_wfs.service;

import com.example.productservice_wfs.fakestoreapi.FakeStoreCreateProductRequest;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements IProductService {

    RestTemplateBuilder restTemplate;

    public ProductService(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public FakeStoreProductResponse getProductById(Long productId) {
        FakeStoreProductResponse dto = restTemplate.build().
                getForEntity("https://fakestoreapi.com/products/{id}",
                        FakeStoreProductResponse.class, productId)
                .getBody();

        return dto;
    }

    @Override
    public List<FakeStoreProductResponse> getAllProducts() {
        FakeStoreProductResponse[] dto =  restTemplate.build().
                getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductResponse[].class).getBody();

        return Arrays.asList(dto);
    }

    @Override
    public FakeStoreProductResponse addProduct(String title, Double price, String description, String image, String category) {
        FakeStoreCreateProductRequest product = new FakeStoreCreateProductRequest();
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImage(image);
        product.setCategory(category);

        HttpEntity<String> body = new HttpEntity<String>(product.toString());

        FakeStoreProductResponse dto = restTemplate
                .build()
                .postForEntity(
                        "https://fakestoreapi.com/products",
                        body,
                        FakeStoreProductResponse.class
                ).getBody();

        return dto;
    }
}
