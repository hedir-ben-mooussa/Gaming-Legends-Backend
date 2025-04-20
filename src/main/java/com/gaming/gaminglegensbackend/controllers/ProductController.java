package com.gaming.gaminglegensbackend.controllers;

import com.gaming.gaminglegensbackend.entities.Product;
import com.gaming.gaminglegensbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "User API", description = "Operations related to users")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int category,
            @RequestParam(required = false) float price,
            @RequestParam(required = false) int quantity,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return productService.getPaginatedProducts(name, category, price, quantity, page, size);
    }
}
