package com.example.productservice_wfs.service;

import com.example.productservice_wfs.dto.CreateProductRequestDTO;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;

import java.util.List;

public interface IProductService {

    FakeStoreProductResponse getProductById(Long productId);

    List<FakeStoreProductResponse> getAllProducts();

    FakeStoreProductResponse patchProduct(Long productId, CreateProductRequestDTO dto);
}
