package sk.stuba.fei.uim.oop.assignment3.shoppingCart;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Item> shoppingList = new ArrayList<>();
    boolean payed;
}
