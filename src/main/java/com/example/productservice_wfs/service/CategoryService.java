package com.example.productservice_wfs.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private RestTemplateBuilder restTemplateBuilder;


    public CategoryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<String> getAllCategories() {
        String[] response = restTemplateBuilder
                .build()
                .getForEntity(
                        "https://fakestoreapi.com/products/categories",
                        String[].class
                        ).getBody();


        assert response != null;
        return Arrays.asList(response);
    }
}
