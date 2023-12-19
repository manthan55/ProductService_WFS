package com.example.productservice_wfs.models;

import com.example.productservice_wfs.fakestoreapi.models.FSRating;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rating extends BaseModel {
    private Double rate;
    private Integer count;

    public Rating(FSRating rating) {
        this.rate = rating.getRate();
        this.count = rating.getCount();
    }
}
