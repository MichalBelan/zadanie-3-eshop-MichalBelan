package sk.stuba.fei.uim.oop.assignment3.item;

import lombok.Getter;


@Getter
public class ItemResponse {
    private Long productId;
    private int amount;

    public ItemResponse(Item item){
        this.productId = item.getProductId();
        this.amount = item.getAmount();
    }
}
