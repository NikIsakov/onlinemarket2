package ru.geekbrains.happy.market.homework.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.happy.market.homework.entities.Score;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
}
