package sk.stuba.fei.uim.oop.assignment3.item.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.item.data.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
