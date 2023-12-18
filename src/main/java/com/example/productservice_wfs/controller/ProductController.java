package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.AddProductRequestDTO;
import com.example.productservice_wfs.fakestoreapi.FakeStoreProductResponse;
import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.service.IProductService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {
    private IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public HttpEntity<Product> getProductById(@PathVariable("productId") Long productId) throws Exception {
        try{
            Product product = productService.getProductById(productId);

            if(Objects.isNull(product)){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("class-name", "integrating APIS");

            return new ResponseEntity<>(product,headers, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public HttpEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody AddProductRequestDTO dto){
        Product product = productService.addProduct(Product.fromAddProductRequestDTO(dto));
        return product;
    }
}

/**
 * HW
 * 1. Go through http status codes
 * 2. Try to take input as headers
 * 3. Implement Update and PUT functionalities **
 * 4. Think of a way which helps us to return some response back to client
 *      in case of errors.
 */