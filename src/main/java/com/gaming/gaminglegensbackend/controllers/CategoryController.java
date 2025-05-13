package com.gaming.gaminglegensbackend.controllers;

import com.gaming.gaminglegensbackend.entities.Category;
import com.gaming.gaminglegensbackend.entities.Product;
import com.gaming.gaminglegensbackend.services.CategoryService;
import com.gaming.gaminglegensbackend.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Tag(name = "User API", description = "Operations related to users")
@CrossOrigin(origins = "*")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
    }
}
