package sk.stuba.fei.uim.oop.assignment3.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

@Getter
public class ProductResponse {


    private Long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private Double price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.amount = product.getAmount();
        this.unit = product.getUnit();
        this.price = product.getPrice();

    }


}
