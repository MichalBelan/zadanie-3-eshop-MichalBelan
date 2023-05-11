package sk.stuba.fei.uim.oop.assignment3.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.item.Item;

@Getter

public class ItemResponse {
    private Long productId;
    private int amount;

    public ItemResponse(Item item){
        this.productId = item.getProductId();
        this.amount = item.getAmount();
    }
}
