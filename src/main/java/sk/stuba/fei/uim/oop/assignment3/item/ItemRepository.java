package sk.stuba.fei.uim.oop.assignment3.item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.item.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
