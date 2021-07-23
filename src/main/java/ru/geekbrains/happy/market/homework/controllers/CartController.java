package ru.geekbrains.happy.market.homework.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.happy.market.homework.model.Product;
import ru.geekbrains.happy.market.homework.services.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1//cart")
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

    @GetMapping("/allProduct")
    public List<Product> getAllProductInCart(){
        return cartService.getProductInCart();
    }

}
