package sk.stuba.fei.uim.oop.assignment3.shoppingCart.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.shoppingCart.data.ShoppingCart;


@Repository
public interface IShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
