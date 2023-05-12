package sk.stuba.fei.uim.oop.assignment3.item.web;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.item.data.Item;


@Getter
public class ItemResponse {
    private Long productId;
    private int amount;

    public ItemResponse(Item item){
        this.productId = item.getProductId();
        this.amount = item.getAmount();
    }
}
