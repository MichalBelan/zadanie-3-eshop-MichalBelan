package sk.stuba.fei.uim.oop.assignment3.product.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;


@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

}
