package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.AmountRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.UpdateBody;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAll();
    Product create(ProductRequest request);
    Product getProductById(Long id);
    Product updateProduct(Long id, UpdateBody updateBody);
    void deleteProduct(Long id);

    int getProductAmount(Long id);

    int incrementAmount(Long id, AmountRequest amountRequest);


}
