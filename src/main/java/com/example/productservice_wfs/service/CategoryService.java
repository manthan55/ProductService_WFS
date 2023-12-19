package com.example.productservice_wfs.service;

import com.example.productservice_wfs.fakestoreapi.FSClient;
import com.example.productservice_wfs.models.Category;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private FSClient fsClient;

    public CategoryService(FSClient fsClient) {
        this.fsClient = fsClient;
    }

    @Override
    public List<Category> getAllCategories() {
        List<String> response = fsClient.getAllCategories();
        return Category.fromStringList(response);
    }
}
