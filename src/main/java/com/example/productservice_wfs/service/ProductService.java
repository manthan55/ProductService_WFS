package com.example.productservice_wfs.service;

import ch.qos.logback.core.util.PropertySetterException;
import com.example.productservice_wfs.exceptions.ProductNotFoundException;
import com.example.productservice_wfs.fakestoreapi.FSClient;
import com.example.productservice_wfs.fakestoreapi.FakeStoreCreateProductRequest;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import com.example.productservice_wfs.fakestoreapi.models.FSProduct;
import com.example.productservice_wfs.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private FSClient fsClient;

    public ProductService(FSClient fsClient) {
        this.fsClient = fsClient;
    }

    @Override
    public Product getProductById(Long productId) {
        FSProduct fsProduct = fsClient.getProduct(productId);
        return Product.fromFSProduct(fsProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        List<FSProduct> fsProducts = fsClient.getAllProducts();
        return Product.fromFSProductList(fsProducts);
    }

    @Override
    public Product addProduct(Product product) {
        FSProduct fsProduct = fsClient.addProduct(FSProduct.fromProduct(product));
        return Product.fromFSProduct(fsProduct);

//
//        FakeStoreCreateProductRequest product = new FakeStoreCreateProductRequest();
//        product.setTitle(title);
//        product.setPrice(price);
//        product.setDescription(description);
//        product.setImage(image);
//        product.setCategory(category);
//
//        HttpEntity<String> body = new HttpEntity<String>(product.toString());
//
//        FakeStoreProductResponse dto = restTemplate
//                .build()
//                .postForEntity(
//                        "https://fakestoreapi.com/products",
//                        product,
//                        FakeStoreProductResponse.class
//                )
//                .getBody();
////                .postForObject(
////                        "https://fakestoreapi.com/products",
////                        product,
////                        FakeStoreProductResponse.class
////                );
//
//        return dto;
    }
}
