package sk.stuba.fei.uim.oop.assignment3.product.web.bodies;

import lombok.Getter;

@Getter
public class AmountResponse {
    private int amount;

    public AmountResponse(int amount) {
        this.amount = amount;

    }
}
