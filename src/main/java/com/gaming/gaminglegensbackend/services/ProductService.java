package com.gaming.gaminglegensbackend.services;

import com.gaming.gaminglegensbackend.entities.Product;
import com.gaming.gaminglegensbackend.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ProductService {
    //dependency injection
    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return (List<Product>) productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }


}
