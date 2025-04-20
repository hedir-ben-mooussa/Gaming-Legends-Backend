package com.gaming.gaminglegensbackend.services;

import com.gaming.gaminglegensbackend.entities.Category;
import com.gaming.gaminglegensbackend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepo.findAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepo.findById(id).get();
    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    public void deleteCategoryById(int id) {
        categoryRepo.deleteById(id);
    }
}
