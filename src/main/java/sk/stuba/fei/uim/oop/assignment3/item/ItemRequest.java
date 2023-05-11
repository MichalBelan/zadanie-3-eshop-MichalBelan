package sk.stuba.fei.uim.oop.assignment3.item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ItemRequest {
    private Long productId;
    private int amount;

    public ItemRequest(Long productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

}