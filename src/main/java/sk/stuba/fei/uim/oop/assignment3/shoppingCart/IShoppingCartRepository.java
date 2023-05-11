package sk.stuba.fei.uim.oop.assignment3.shoppingCart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.shoppingCart.ShoppingCart;

@Repository
public interface IShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
