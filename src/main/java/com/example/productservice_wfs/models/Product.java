package com.example.productservice_wfs.models;


import com.example.productservice_wfs.dto.AddProductRequestDTO;
import com.example.productservice_wfs.fakestoreapi.models.FSProduct;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Product extends BaseModel{
    String title;
    Double price;
    String description;
    Category category;
    String image;

    public static Product fromFSProduct(FSProduct fsProduct){
        if(fsProduct == null) return null;
        
        Product p = new Product();
        p.setTitle(fsProduct.getTitle());
        p.setPrice(fsProduct.getPrice());
        p.setDescription(fsProduct.getDescription());
        p.setImage(fsProduct.getImage());

        Category c = new Category();
        c.setName(fsProduct.getCategory());
        c.setDescription(fsProduct.getCategory());

        p.setCategory(c);

        return p;
    }


    public static List<Product> fromFSProductList(List<FSProduct> fsProducts){
        List<Product> products = new ArrayList<>();

        for (FSProduct fsProduct : fsProducts) {
            products.add(fromFSProduct(fsProduct));
        }

        return products;
    }

    public static Product fromAddProductRequestDTO(AddProductRequestDTO productDTO){
        if(productDTO == null) return null;
        
        Product p = new Product();
        p.setTitle(productDTO.getTitle());
        p.setPrice(productDTO.getPrice());
        p.setDescription(productDTO.getDescription());
        p.setImage(productDTO.getImage());

        Category c = new Category();
        c.setName(productDTO.getCategory());
        c.setDescription(productDTO.getCategory());

        p.setCategory(c);

        return p;
    }
}
