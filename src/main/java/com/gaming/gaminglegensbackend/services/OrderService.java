package com.gaming.gaminglegensbackend.services;

import com.gaming.gaminglegensbackend.entities.Order;
import com.gaming.gaminglegensbackend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepo.findAll();
    }
    public Order getOrderById(int id) {
        return orderRepo.findById(id).orElse(null);
    }
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }
    public void deleteOrderById(int id) {
        orderRepo.deleteById(id);
    }
}
