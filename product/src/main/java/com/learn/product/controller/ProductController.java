package com.learn.product.controller;

import com.learn.product.dto.Product;
import com.learn.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    ResponseEntity<Product> addProduct(@RequestBody Product product) {
        String status = productService.addProduct(product);
        LOGGER.info("Product added status - {}", status);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/productList")
    List<Product> productList() {
        return productService.listAllProducts();
    }

    @GetMapping("/productList/{category}")
    List<Product> productCategoryList(@PathVariable String category) {
        return productService.listAllProductsByCategory(category);
    }

    @GetMapping("/product/{id}")
    Product productCategoryList(@PathVariable Integer id) {
        return productService.productsById(id);
    }

    @PutMapping("/update")
    String updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    String deleteProductById(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }
}
