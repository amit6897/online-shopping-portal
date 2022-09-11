package com.learn.product.repository;

import com.learn.product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

// MongoRepository works same as JpaRepository
public interface ProductRepository extends MongoRepository<Product, Integer> {
    @Query("{'Category.name':?0}")
    List<Product> findByCategory(String category);
}
