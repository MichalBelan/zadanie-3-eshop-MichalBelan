package sk.stuba.fei.uim.oop.assignment3.shoppingCart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.BadRequestException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.item.data.Item;
import sk.stuba.fei.uim.oop.assignment3.item.data.ItemRepository;
import sk.stuba.fei.uim.oop.assignment3.item.web.ItemRequest;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.shoppingCart.data.IShoppingCartRepository;
import sk.stuba.fei.uim.oop.assignment3.shoppingCart.data.ShoppingCart;


import java.util.Optional;
@Service
public class ShoppingCartService implements IShoppingCartService {
    private IShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ItemRepository cartItemsRepository;

    @Autowired
    private IProductService productService;


    @Autowired
    public ShoppingCartService(IShoppingCartRepository repository) {
        this.shoppingCartRepository = repository;
    }

    @Override
    public ShoppingCart create() {
        ShoppingCart shoppingCart = new ShoppingCart();
        return this.shoppingCartRepository.save(shoppingCart);

    }

    @Override
    public ShoppingCart getShoppingCartById(Long id) {
        Optional<ShoppingCart> optionalShoppingCart = this.shoppingCartRepository.findById(id);
        return optionalShoppingCart.orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteShoppingCartById(Long id) {
        Optional<ShoppingCart> optionalShoppingCart = this.shoppingCartRepository.findById(id);
        ShoppingCart shoppingCart = optionalShoppingCart.orElseThrow(NotFoundException::new);
        this.shoppingCartRepository.delete(shoppingCart);
    }

    @Override
    public ShoppingCart addProductToCart(Long id, ItemRequest item) {
        Product product = this.productService.getProductById(item.getProductId());
        ShoppingCart cart = getShoppingCartById(id);
        if (cart.isPayed() || product.getAmount() - item.getAmount() < 0) {
            throw new BadRequestException();
        }
        boolean found = false;
        Item cartItem = new Item();
        for (Item ci : cart.getShoppingList()) {
            if (ci.getProductId().equals(item.getProductId())) {
                found = true;
                cartItem = ci;
                break;
            }
        }

        if (found) {
            cartItem.setAmount(cartItem.getAmount() + item.getAmount());


        } else {
            cartItem.setProductId(item.getProductId());
            cartItem.setAmount(item.getAmount());
            cart.getShoppingList().add(cartItem);
        }
        this.cartItemsRepository.save(cartItem);

        product.setAmount(product.getAmount() - item.getAmount());

        this.cartItemsRepository.save(cartItem);
        return cart;


    }

    @Override
    public String payForShopping(Long id) {
        ShoppingCart cart = this.getShoppingCartById(id);
        if (cart.isPayed()) {
            throw new BadRequestException();
        }
        Double price = 0D;
        for (Item item : cart.getShoppingList()) {
            Product product = this.productService.getProductById(item.getProductId());
            price += product.getPrice() * item.getAmount();
        }

        cart.setPayed(true);
        this.shoppingCartRepository.save(cart);
        return price.toString();
    }


}
