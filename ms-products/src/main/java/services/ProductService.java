package services;

import entities.Product;
import entities.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<ProductDto> findProductById(Long id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    public Product findProductByIdForCart(Long id){
        return productRepository.findById(id).get();
    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        if(page < 0)
            throw new RuntimeException();
        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

    public List<Product> findAllByPrice(int min, int max) {
        return productRepository.findAllByCostGreaterThanEqualAndCostLessThan(min, max);
    }

    public Product saveOrUpdate(Product product) {
        return productRepository.save(product);
    }


    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}