package com.example.productservice_wfs;

import com.example.productservice_wfs.models.Category;
import com.example.productservice_wfs.models.Product;
import com.example.productservice_wfs.repositories.CategoryRepository;
import com.example.productservice_wfs.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void saveProductAndCategory(){
        Category c = new Category();
        c.setName("Electronics");
        c.setDescription("electronic category desc");
        Category savedC = categoryRepository.save(c);

        Product p = new Product();
        p.setTitle("iPhone 15");
        p.setCategory(savedC);
        Product savedP = productRepository.save(p);

//        System.out.println(savedC);
        System.out.println(savedP.getTitle());
        System.out.println(savedC.getName());
    }
}
