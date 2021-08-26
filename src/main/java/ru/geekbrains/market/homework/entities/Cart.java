package ru.geekbrains.market.homework.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "countItem")
    private int countItem;

    @OneToMany(mappedBy = "cart")
    List<Product> products;
}
