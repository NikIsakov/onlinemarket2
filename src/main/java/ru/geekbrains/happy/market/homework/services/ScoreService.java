package ru.geekbrains.happy.market.homework.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.happy.market.homework.entities.Score;
import ru.geekbrains.happy.market.homework.repositories.ScoreRepository;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

}
