package com.learn.product.service;

import com.learn.product.dto.Product;
import com.learn.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public String addProduct(Product product) {
        repository.save(product);
        return "success";
    }

    public List<Product> listAllProducts() {
        return repository.findAll();
    }

    public List<Product> listAllProductsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public Product productsById(Integer id) {
        return repository.findById(id).get();
    }

    public String updateProduct(Product product) {
        repository.save(product);
        return "product updated";
    }

    public String deleteProductById(Integer id) {
        repository.deleteById(id);
        return "product deleted";
    }

    //List<Product> products = new ArrayList<>();   --> we used this list when we are temporary storing data in the inMemory
    /*
    public String addProduct(Product product) {
        products.add(product);
        return "success";
    }

    public List<Product> listAllProducts() {
        return products;
    }

    public List<Product> listAllProductsByCategory(String category) {
        return products.stream().filter(product -> product.getCategory().getName().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public Product productsById(Integer id) {
        return products.stream().filter(product -> product.getId()==id)
                .findAny().get();
    }

    public String updateProduct(Product product) {
        for (Product prod: products) {
            if (prod.getId()== product.getId()) {
                prod.setName(product.getName());
                prod.setCategory(product.getCategory());
                prod.setDiscount(prod.getDiscount());
                prod.setDiscountDescription(product.getDiscountDescription());

                return "product updated successfully";
            }
        }
        return "product updation failed";
    }

    public String deleteProductById(Integer id) {
        for (Product product : products) {
            if (product.getId()==id) {
                products.remove(product);
                return "product deleted";
            }
        }
        return "product deletion failed";
    }
    */
}
