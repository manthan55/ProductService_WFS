package com.example.productservice_wfs.controller;

import com.example.productservice_wfs.dto.*;
import com.example.productservice_wfs.exceptions.ProductNotFoundException;
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
    public HttpEntity<ProductResponseDTO> getProductById(@PathVariable("productId") Long productId) throws Exception {
        try{
            Product product = productService.getProductById(productId);

            if(Objects.isNull(product)){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("class-name", "integrating APIS");

            return new ResponseEntity<>(ProductResponseDTO.fromProduct(product),headers, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public HttpEntity<List<ProductResponseDTO>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(ProductResponseDTO.fromProductList(products), HttpStatus.OK);
    }

    @PostMapping("/")
    public HttpEntity<AddProductResponseDTO> createProduct(@RequestBody AddProductRequestDTO dto){
        Product product = productService.addProduct(Product.fromAddProductRequestDTO(dto));
        return new ResponseEntity<>(AddProductResponseDTO.fromProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public HttpEntity<EditProductResponseDTO> editProduct(@PathVariable(name = "productId") Long productId, @RequestBody EditProductRequestDTO dto) throws ProductNotFoundException {
        try{
            Product product = productService.editProduct(productId, Product.fromEditProductRequestDTO(dto));
            return new ResponseEntity<>(EditProductResponseDTO.fromProduct(product), HttpStatus.OK);
        }
        catch(ProductNotFoundException e){
            // ToDo -- pass an error message stating product not found
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(path = "/{productId}")
    public HttpEntity<ProductResponseDTO> deleteProduct(@PathVariable(name = "productId") Long productId){
        try{
            Product deletedProduct = productService.deleteProduct(productId);
            return new ResponseEntity<>(ProductResponseDTO.fromProduct(deletedProduct), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
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