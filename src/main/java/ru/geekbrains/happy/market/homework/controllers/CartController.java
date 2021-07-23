package ru.geekbrains.happy.market.homework.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.happy.market.homework.services.CartService;

@RestController
@RequestMapping("/products/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;


    @GetMapping("/addProduct/{id}")
    public void addProduct(@PathVariable Long id){
        cartService.addProductToCart(id);
    }

    @GetMapping("/clear")
    public void delete(){
        cartService.clear();
    }

}
