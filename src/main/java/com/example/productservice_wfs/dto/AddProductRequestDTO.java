package com.example.productservice_wfs.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AddProductRequestDTO {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;
}
