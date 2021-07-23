package ru.geekbrains.happy.market.homework.services;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.happy.market.homework.model.ProductDto;

import java.util.*;

@Service
@Data
@NoArgsConstructor
public class CartService {
    private List<Optional<ProductDto>> productInCart = new ArrayList<>();
    private ProductService productService;

    public void clear() {
        productInCart.clear();
    }

    public void addProductToCart(Long id) {
        Optional<ProductDto> product = productService.findProductById(id);
        productInCart.add(product);
    }
}
