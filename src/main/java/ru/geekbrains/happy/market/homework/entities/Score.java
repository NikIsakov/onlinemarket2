package ru.geekbrains.happy.market.homework.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "score")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private int value;
}
