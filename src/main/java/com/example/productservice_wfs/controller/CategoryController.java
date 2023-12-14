package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    private List<String> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/headers")
    private String readHeader(@RequestHeader(name = "my-custom-header", required = false) String headerValue){
        return "Header value : "+headerValue;
    }
}
