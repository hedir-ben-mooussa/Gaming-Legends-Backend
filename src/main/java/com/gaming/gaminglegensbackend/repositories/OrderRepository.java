package com.gaming.gaminglegensbackend.repositories;

import com.gaming.gaminglegensbackend.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
