package com.gaming.gaminglegensbackend.repositories;

import com.gaming.gaminglegensbackend.entities.Category;
import com.gaming.gaminglegensbackend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    Page<Product> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndPriceBetween(
            String name, int category, float price, int quantity, Pageable pageable);
}