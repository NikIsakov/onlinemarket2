package ru.geekbrains.happy.market.homework.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.happy.market.homework.services.ScoreService;

@RestController
@RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;

}
