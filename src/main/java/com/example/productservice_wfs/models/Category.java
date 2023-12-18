package com.example.productservice_wfs.models;

import lombok.Data;

import java.util.List;

@Data
public class Category extends BaseModel {
    String name;
    String description;
    List<Product> products;
}
