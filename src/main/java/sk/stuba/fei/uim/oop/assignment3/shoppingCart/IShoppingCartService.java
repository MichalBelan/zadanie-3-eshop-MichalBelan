package sk.stuba.fei.uim.oop.assignment3.shoppingCart;

import sk.stuba.fei.uim.oop.assignment3.item.ItemRequest;
import sk.stuba.fei.uim.oop.assignment3.shoppingCart.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {
    ShoppingCart create();

    ShoppingCart getShoppingCartById(Long id);

    void deleteShoppingCartById(Long id);

    ShoppingCart addProductToCart(Long id, ItemRequest item);

    String payForShopping(Long id);


}
