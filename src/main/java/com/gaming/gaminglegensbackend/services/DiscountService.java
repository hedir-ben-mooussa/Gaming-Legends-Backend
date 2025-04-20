package com.gaming.gaminglegensbackend.services;

import com.gaming.gaminglegensbackend.entities.Discount;
import com.gaming.gaminglegensbackend.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepository discountRepo;

    public List<Discount> getAllDiscounts() {
        return (List<Discount>) discountRepo.findAll();
    }

    public Discount getDiscountById(int id) {
        return discountRepo.findById(id).get();
    }

    public Discount saveDiscount(Discount discount) {
        return discountRepo.save(discount);
    }

    public void deleteDiscountById(int id) {
        discountRepo.deleteById(id);
    }
}
