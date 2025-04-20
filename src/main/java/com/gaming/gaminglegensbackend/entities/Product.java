package com.gaming.gaminglegensbackend.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = true)
    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
}
