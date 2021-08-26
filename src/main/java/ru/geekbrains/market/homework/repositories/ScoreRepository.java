package ru.geekbrains.market.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.market.homework.entities.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

}
