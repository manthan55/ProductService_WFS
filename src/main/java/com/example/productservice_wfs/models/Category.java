package com.example.productservice_wfs.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Category extends BaseModel {
    String name;
    String description;
    List<Product> products;

    public static Category fromString(String category){
        Category c = new Category();
        c.setName(category);
        c.setDescription(category);
        return c;
    }
    
    public static List<Category> fromStringList(List<String> categories){
        List<Category> categoriesList = new ArrayList<>();

        for (String category :
                categories) {
            categoriesList.add(fromString(category));
        }
        
        return categoriesList;
    }
}
