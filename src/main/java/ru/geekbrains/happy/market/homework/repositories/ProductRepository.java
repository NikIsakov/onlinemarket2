package ru.geekbrains.happy.market.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.happy.market.homework.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByCostGreaterThanEqualAndCostLessThan(int min, int max);

    List<Product> findAllByCostIsLessThan(int max);

    List<Product> findAllByCostGreaterThan(int min);

    List<Product> findAllByTitleContains(String word);

}
