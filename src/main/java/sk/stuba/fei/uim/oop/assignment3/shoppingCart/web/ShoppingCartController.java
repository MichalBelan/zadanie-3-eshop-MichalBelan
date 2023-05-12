package sk.stuba.fei.uim.oop.assignment3.shoppingCart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.item.web.ItemRequest;
import sk.stuba.fei.uim.oop.assignment3.shoppingCart.logic.IShoppingCartService;
import sk.stuba.fei.uim.oop.assignment3.shoppingCart.web.bodies.ShoppingCartResponse;


@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService service;

    @PostMapping
    public ResponseEntity<ShoppingCartResponse> addCart(){
        return new ResponseEntity<>(new ShoppingCartResponse(this.service.create()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ShoppingCartResponse getShoppingCartById(@PathVariable("id") Long id){
        return new ShoppingCartResponse(this.service.getShoppingCartById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteShoppingCartById(@PathVariable("id") Long id){
        this.service.deleteShoppingCartById(id);
    }

    @PostMapping("/{id}/add")
    public ShoppingCartResponse addProductToCart(@PathVariable("id") Long id, @RequestBody ItemRequest request) {
        return new ShoppingCartResponse(this.service.addProductToCart(id, request));
    }
    @GetMapping("/{id}/pay")
    public String payForShopping(@PathVariable("id") Long id){
        return this.service.payForShopping(id);
    }
}
