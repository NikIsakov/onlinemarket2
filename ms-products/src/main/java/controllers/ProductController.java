package controllers;

import entities.Product;
import entities.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import exceptions.ResourceNotFoundException;
import repositories.specifications.ProductSpecifications;
import services.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Component
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

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable Long id){
        productService.deleteById(id);
    }
}
