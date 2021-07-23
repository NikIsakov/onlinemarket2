package ru.geekbrains.happy.market.homework.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.happy.market.homework.model.Product;
import ru.geekbrains.happy.market.homework.model.ProductDto;
import ru.geekbrains.happy.market.homework.services.CartService;

@RestController
@RequestMapping("/products/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @RequestMapping(value="/addProduct/{id}",method = RequestMethod.GET)
    public String addProduct(@PathVariable("id") Integer id){
        Product product = cartService.getProductInCart(id);


        return "redirect:/";
    }

}
