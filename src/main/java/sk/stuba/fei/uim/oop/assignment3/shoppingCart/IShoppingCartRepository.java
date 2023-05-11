package sk.stuba.fei.uim.oop.assignment3.shoppingCart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
