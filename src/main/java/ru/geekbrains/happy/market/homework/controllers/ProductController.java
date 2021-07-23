package ru.geekbrains.happy.market.homework.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.happy.market.homework.exceptions.ResourceNotFoundException;
import ru.geekbrains.happy.market.homework.model.Product;
import ru.geekbrains.happy.market.homework.model.ProductDto;
import ru.geekbrains.happy.market.homework.repositories.ProductRepository;
import ru.geekbrains.happy.market.homework.services.ProductService;
import ru.geekbrains.happy.market.homework.repositories.specifications.ProductSpecifications;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        if (page < 1) {
            page = 1;
        }
        return productService.findAll(ProductSpecifications.build(params), page, 2);
    }

    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Продукта под данным id" + id+" не существует"));
    }

    @PostMapping
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return productService.saveOrUpdate(product);
    }

    @GetMapping("/delete{id}")
    public void delete(@PathVariable Long id){
        productService.deleteById(id);
    }
}
