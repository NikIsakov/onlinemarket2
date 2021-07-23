package ru.geekbrains.happy.market.homework.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import ru.geekbrains.happy.market.homework.model.Product;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Data
public class CartService {
    Map<Product,Integer> productInCart = new LinkedHashMap<>();

    public void addProductToCart(Product product, int count) {
        productInCart.put(product, count);
    }

}
