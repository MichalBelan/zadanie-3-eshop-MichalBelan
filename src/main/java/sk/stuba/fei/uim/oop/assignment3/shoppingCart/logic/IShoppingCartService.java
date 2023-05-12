package sk.stuba.fei.uim.oop.assignment3.shoppingCart.logic;

import sk.stuba.fei.uim.oop.assignment3.item.web.ItemRequest;
import sk.stuba.fei.uim.oop.assignment3.shoppingCart.data.ShoppingCart;


public interface IShoppingCartService {
    ShoppingCart create();

    ShoppingCart getShoppingCartById(Long id);

    void deleteShoppingCartById(Long id);

    ShoppingCart addProductToCart(Long id, ItemRequest item);

    String payForShopping(Long id);

}
