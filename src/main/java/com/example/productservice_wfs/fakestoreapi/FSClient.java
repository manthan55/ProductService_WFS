package com.example.productservice_wfs.fakestoreapi;

import com.example.productservice_wfs.fakestoreapi.models.FSProduct;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FSClient implements IFakeStoreAdapter{
    private RestTemplate restTemplate;

    public FSClient(RestTemplateBuilder restTemplatebuilder) {
        this.restTemplate = restTemplatebuilder.build();
    }

    @Override
    public FSProduct getProduct(Long id) {
        FSProduct product = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{productId}",
                FSProduct.class,
                id
        ).getBody();
        return product;
    }

    @Override
    public List<FSProduct> getAllProducts() {
        FSProduct[] products = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FSProduct[].class
        ).getBody();
        return Arrays.asList(products);
    }

    @Override
    public FSProduct addProduct(FSProduct product) {
        FSProduct addedProduct = restTemplate.postForEntity(
                "https://fakestoreapi.com/products",
                product,
                FSProduct.class
        ).getBody();
        return addedProduct;
    }

    @Override
    public FSProduct updateProduct(Long id, FSProduct product) {
        return null;
    }

    @Override
    public List<String> getAllCategories() {
        String[] categories = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class
        ).getBody();
        return Arrays.asList(categories);
    }
}
