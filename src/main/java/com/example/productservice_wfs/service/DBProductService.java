package com.example.productservice_wfs.service;

import com.example.productservice_wfs.exceptions.ProductNotFoundException;
import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// https://stackoverflow.com/a/19232501/6818945
@Service("DBProductService")
public class DBProductService implements IProductService{
    private ProductRepository productRepository;

    public DBProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        Product addedProduct = productRepository.save(product);
        return addedProduct;
    }

    @Override
    public Product editProduct(Long productId, Product product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) throws ProductNotFoundException {
        return null;
    }
}
