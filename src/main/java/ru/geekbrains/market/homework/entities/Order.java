package ru.geekbrains.market.homework.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToOne
    @JoinColumn(name = "orderItems_id")
    private OrderItems orderItems;

    @ManyToOne
    @JoinColumn(name = "user_table_id")
    private User user;
}
