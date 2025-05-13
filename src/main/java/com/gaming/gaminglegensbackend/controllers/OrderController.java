package com.gaming.gaminglegensbackend.controllers;

import com.gaming.gaminglegensbackend.dto.OrderDto;
import com.gaming.gaminglegensbackend.entities.Order;
import com.gaming.gaminglegensbackend.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

   @GetMapping("/{id}")
    public Order getOrdersById(@PathVariable int id) {
        return orderService.getOrderById(id);
   }

   @PostMapping()
    public Order createOrder(@RequestBody OrderDto order) {
        return orderService.saveOrder(order);
   }
   @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable int id) {
        orderService.deleteOrderById(id);
   }

    @PatchMapping("complete-order/{id}")
    public void changeOrder(@PathVariable int id) {
        orderService.changeOrder(id);
    }
}
