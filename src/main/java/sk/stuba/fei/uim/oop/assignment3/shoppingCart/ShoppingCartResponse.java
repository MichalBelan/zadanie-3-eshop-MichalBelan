package sk.stuba.fei.uim.oop.assignment3.shoppingCart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.item.ItemResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ShoppingCartResponse {

    private Long id;
    private List<ItemResponse> shoppingList = new ArrayList<>();
    private boolean payed;

    public ShoppingCartResponse(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.shoppingList.addAll(shoppingCart.getShoppingList().stream().map(ItemResponse::new).collect(Collectors.toList()));
        this.payed = shoppingCart.isPayed();
    }

}
