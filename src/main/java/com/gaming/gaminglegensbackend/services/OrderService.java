package com.gaming.gaminglegensbackend.services;

import com.gaming.gaminglegensbackend.dto.OrderDto;
import com.gaming.gaminglegensbackend.entities.Order;
import com.gaming.gaminglegensbackend.entities.User;
import com.gaming.gaminglegensbackend.enums.Status;
import com.gaming.gaminglegensbackend.repositories.OrderRepository;
import com.gaming.gaminglegensbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Order> getAllOrders() {
        return (List<Order>) orderRepo.findAll();
    }
    public Order getOrderById(int id) {
        return orderRepo.findById(id).orElse(null);
    }
    public Order saveOrder(OrderDto orderdto) {
        System.out.println("test"+orderdto);

        User user = this.userRepo.findByEmail(orderdto.getEmail());
        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(orderdto.getTotalPrice());
        order.setStatus(orderdto.getStatus());
        order.setPaymentType(orderdto.getPaymentType());
        order.setAddress(orderdto.getAddress());
        order.setCountry(orderdto.getCountry());

        return orderRepo.save(order);
    }
    public void deleteOrderById(int id) {
        orderRepo.deleteById(id);
    }

    public Order changeOrder(int id) {
        Order order = orderRepo.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(Status.completed);  // Set status
           return orderRepo.save(order);        // Save updated order
        }else{
            return null;
        }
    }

}
